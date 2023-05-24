package Controller.Rent;

import Dao.BookRent.BookRent;

import java.sql.Date;
import java.util.LinkedList;

public class RentRepository {

    private static final RentRepository instance = new RentRepository();
    private final LinkedList<BookRent> bookRepository = new LinkedList<>();

    public LinkedList<BookRent> getBookRent() {
        return bookRepository;
    }

    private RentRepository() {
        bookRepository.add(new BookRent("승우","한국소설 1", 1, Date.valueOf("2023-05-20"), 500));
        bookRepository.add(new BookRent("승훈","한국소설 2", 2, Date.valueOf("2023-05-25"), 500));
        bookRepository.add(new BookRent("무광", "서양소설 1",3, Date.valueOf("2023-05-23"), 500));
    }

    public static RentRepository getInstance() {
        return instance;
    }

    public void add(BookRent bookRent) {
        // TODO Auto-generated method stub
        bookRepository.add(bookRent);
    }

    public void delete(String name, int id) {
        bookRepository.removeIf(bookRent -> bookRent.getBook_id() == id && bookRent.getUser_name().equals(name));
    }
}
