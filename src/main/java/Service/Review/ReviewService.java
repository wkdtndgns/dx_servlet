package Service.Review;

import Dao.Book.*;
import Dao.BookReivew.BookReview;

import java.io.*;
import java.sql.SQLException;
import java.util.Scanner;

public class ReviewService {
    static BookDao bookDao = new BookDao();

    public static void main(String[] args) throws SQLException {
        setRate();
    }


    public static boolean setRate() throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("사용자 명을 입력하세요: ");
//        String userName = scanner.nextLine();
//
//        System.out.println("평점을 남길 책을 입력하세요: ");
//        String bookName = scanner.nextLine();
        if (!bookDao.validateName(bookName)) {
//            System.out.println("존재하지 않는 책입니다.");
            return false;
        }

//        System.out.println("평점을 입력하세요: ");
//        int rate = scanner.nextInt();
        Book book = bookDao.getBookQtyByBookName(bookName);
        int bookId = book.getBookId();

        BookReview bookReview = new BookReview(userName, bookName, bookId, rate);

        StringBuffer sb = new StringBuffer("");
        try {
            Reader r = new FileReader("review.txt");
            BufferedReader br = new BufferedReader(r);
            // 한 줄씩 읽기
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
                String[] arr = line.split("\\|\\s*");
            }
            sb.append(bookReview.getUser_name()).append("|").append(bookReview.getBook_id()).append("|").append(bookReview.getRate());
            Writer writer = new FileWriter("review.txt");
            writer.write(sb.toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public static int getRate() {
        int sum = 0;
        int cnt = 0;
        int avg = 0;
        try {
            Reader r = new FileReader("review.txt");
            BufferedReader br = new BufferedReader(r);
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split("\\|\\s*");
                String userName = arr[0];
                int bookId = Integer.parseInt(arr[1]);
                int rate = Integer.parseInt(arr[2]);
                sum += rate;
                ++cnt;
                avg = rate/cnt;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return avg;
    }

}
