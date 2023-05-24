package Service.Rent;

import Repository.RentRepository;
import Dao.Book.*;
import Dao.BookRent.*;
import Controller.User.User;
import Repository.UserRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.Optional;

public class RentService {
    static BookDao bookDao = new BookDao();
    private static final RentRepository rentRepository = RentRepository.getInstance();
    private static final UserRepository userRepository = UserRepository.getInstance();

    public static LinkedList<BookRent> getRentListHistory(){
       return rentRepository.getBookRent();
    }
    /**
     * 대출
     *
     * @return
     * @throws SQLException
     */
    public static boolean setRent(String userName, String bookName) throws SQLException {

        LinkedList<User> userList = userRepository.getusers();
        for (User user : userList) System.out.println(user);

        Optional<User> findUser = userList.stream()
                .filter(User -> User.getName().equals(userName) )
                .findFirst();

        if(!findUser.isPresent()){
            System.out.println("사용자가 없습니다.");
            return false;
        }

        System.out.println(userName);
        System.out.println(bookName);
        Book book = bookDao.getBookQtyByBookName(bookName);
        if (book == null || book.getQty() <= 0) {
            System.out.println("책이 없습니다.");
            return false;
        }
        System.out.println("책 개수: " + book.getQty());

        // 책 대출 로직 start
        LocalDate currentDate = LocalDate.now();
        // 7일을 더한 날짜 계산
        LocalDate futureDate = currentDate.plusDays(7);
        // 날짜 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 문자열로 변환
        String futureDateStr = futureDate.format(formatter);
        BookRent bookRent = new BookRent();
        bookRent.setBook_name(bookName);
        bookRent.setBook_id(book.getBookId());
        bookRent.setEnd_date(Date.valueOf(futureDateStr));
        bookRent.setUser_name(userName);

        rentRepository.add(bookRent);

        // 책 대출 로직 end

        // 수량 업데이트
        book.setQty(book.getQty() - 1);
        int result = bookDao.updateQty(book);
        if (!(result > 0)) {
            System.out.println("업데이트 실패");
            return false;
        }

        return true;
    }

    /**
     * 반납
     *
     * @return
     * @throws SQLException
     */
    public static boolean setReturn(String userName, String bookName) throws SQLException {

        Book book = bookDao.getBookQtyByBookName(bookName);
        if (book == null || book.getQty() <= 0) {
            System.out.println("책이 없습니다.");
            return false;
        }
        Optional<BookRent> foundRent = rentRepository.getBookRent().stream()
                .filter(bookRent -> bookRent.getBook_id() == book.getBookId() && bookRent.getUser_name().equals(userName))
                .findFirst();

        if (foundRent.isPresent()) {
            BookRent bookRent = foundRent.get();
            LocalDate currentDate = LocalDate.now();
            long i = ChronoUnit.DAYS.between(bookRent.getEnd_date().toLocalDate(), currentDate);

            if (i > 0) {
                System.out.println("연체일은 " + i);
                System.out.println("연체료는 " + bookRent.getRent_pay() * i + "원 입니다.");
            }

            System.out.println("반납 완료");

            rentRepository.delete(userName, book.getBookId());

            // 수량 업데이트
            book.setQty(book.getQty() + 1);
            int result = bookDao.updateQty(book);
            if (!(result > 0)) {
                System.out.println("업데이트 실패");
                return false;
            }
        }

        return true;
    }
}
