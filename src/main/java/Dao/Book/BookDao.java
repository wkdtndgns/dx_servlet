package Dao.Book;

import Jdbc.JdbcComm;

import java.math.BigDecimal;
import java.sql.*;
import java.util.LinkedList;
import java.util.Scanner;

public class BookDao {
    public LinkedList<Book> getBook() throws SQLException {
        JdbcComm jdbc = new JdbcComm();
        Statement statement = jdbc.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT book_id,category_1,category_2, book_name,author FROM t_book" );
        LinkedList<Book> liBook = new LinkedList<>();

        while (resultSet.next()) {
            Book book = new Book();
            book.setBookId(resultSet.getInt("book_id"));
            book.setCategory1(resultSet.getInt("category_1"));
            book.setCategory2(resultSet.getInt("category_2"));
            book.setBookName(resultSet.getString("book_name"));
            book.setAuthor(resultSet.getString("author"));

            liBook.add(book);
        }
        resultSet.close();
        statement.close();
        jdbc.closeConnection();
        return liBook;
    }

    public int insert(Book book) throws SQLException {
        JdbcComm jdbc = new JdbcComm();
        Connection connection = jdbc.getConnection();

        String insertQuery = "INSERT INTO t_book (category_1, category_2, book_name, summary, author, publisher, purchase_price, selling_price, qty, img, page, edition) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setInt(1, book.getCategory1());
        statement.setInt(2, book.getCategory2());
        statement.setString(3, book.getBookName());
        statement.setString(4, book.getSummary());
        statement.setString(5, book.getAuthor());
        statement.setString(6, book.getPublisher());
        statement.setBigDecimal(7, book.getPurchasePrice());
        statement.setBigDecimal(8, book.getSellingPrice());
        statement.setInt(10, book.getQty());
        statement.setString(11, book.getImg());
        statement.setInt(12, book.getPage());
        statement.setInt(13, book.getEdition());

        int result = statement.executeUpdate();
        statement.close();
        jdbc.closeConnection();

        return result;
    }

    public BigDecimal getDiscountRate(int book_id) throws SQLException {
        JdbcComm jdbc = new JdbcComm();
        Statement statement = jdbc.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT discount_rate FROM t_book where book_id = " + book_id);
        BigDecimal discountRate = null;
        while (resultSet.next()) {
            Book book = new Book();
//            book.setIsDeleted(resultSet.getString("is_deleted").charAt(0));
            book.setDiscountRate(resultSet.getBigDecimal("discount_rate"));
            discountRate = book.getDiscountRate();
        }
        resultSet.close();
        statement.close();
        jdbc.closeConnection();
        return discountRate;
    }

    // BOOK의 ID가 있는지 없는지 검사
    public boolean validateId(int book_id) throws SQLException {
        JdbcComm jdbc = new JdbcComm();
        Statement statement = jdbc.getConnection().createStatement();

        String query = "SELECT COUNT(*) AS count FROM t_book WHERE book_id = " + book_id;
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            int count = resultSet.getInt("count");
            return count > 0;
        }

        return false;
    }

    public boolean validateName(String name) throws SQLException {
        JdbcComm jdbc = new JdbcComm();

        // 쿼리 실행
        String query = "SELECT COUNT(*) AS COUNT FROM t_book WHERE book_name = ?";
        PreparedStatement statement = jdbc.getConnection().prepareStatement(query);
        statement.setString(1, name); // name 변수에 적절한 값 설정
        ResultSet resultSet = statement.executeQuery();

        // 결과 처리
        if (resultSet.next()) {
            int count = resultSet.getInt("count");
            System.out.println("책 개수: " + count);
            return count > 0;
        }

        return false;
    }

    public Book getBookQtyByBookName(String name) throws SQLException {
        JdbcComm jdbc = new JdbcComm();
        Book book = new Book();
        // 쿼리 실행
        String query = "SELECT qty, book_id, purchase_price, selling_price FROM t_book WHERE book_name = ?";
        PreparedStatement statement = jdbc.getConnection().prepareStatement(query);
        statement.setString(1, name); // name 변수에 적절한 값 설정
        ResultSet resultSet = statement.executeQuery();

        // 결과 처리
        if (resultSet.next()) {
            book.setQty(resultSet.getInt("qty"));
            book.setBookId(resultSet.getInt("book_id"));
            book.setPurchasePrice(resultSet.getBigDecimal("purchase_price"));
            book.setSellingPrice(resultSet.getBigDecimal("selling_price"));

//            System.out.println("책 개수: " + book.getQty());
            return book;
        }

        return null;
    }

    // book이 삭제되었는지 확인
    public boolean isDeleted(int bookId) throws SQLException {
        JdbcComm jdbc = new JdbcComm();
        Statement statement = jdbc.getConnection().createStatement();

        String query = "SELECT is_deleted FROM t_book WHERE book_id = " + bookId;
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            String isDeleted = resultSet.getString("is_deleted");
            return isDeleted.equalsIgnoreCase("T");
        }

        return false;
    }

    // 할인율 적용시켜서 Selling price 갱신
    public void applyDiscount(int bookId) throws SQLException {
        JdbcComm jdbc = new JdbcComm();
        Statement statement = jdbc.getConnection().createStatement();

//        // Receive input from the user
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the book ID to apply discount: ");
//        int bookId = scanner.nextInt();
//        scanner.nextLine(); // Consume the newline character

//        System.out.print("Enter the discount rate (e.g., 0.1 for 10%): ");
//        double discountRate = scanner.nextDouble();

        BigDecimal discountRate = getDiscountRate(bookId); // book에서 가져와야 됨

        // Update the selling price with the discount
        String updateQuery = "UPDATE t_book SET selling_price = selling_price * (1 - " + discountRate + ") WHERE book_id = " + bookId;
        int rowsAffected = statement.executeUpdate(updateQuery);

        if (rowsAffected > 0) {
            System.out.println("Selling price updated successfully!");
        } else {
            System.out.println("Book ID not found in the database.");
        }

        // Close resources
        statement.close();
        jdbc.closeConnection();
//        scanner.close();
    }

    // id 받아서 is_deleted 값을 T
    public void deleteBook(int bookId) throws SQLException {
        JdbcComm jdbc = new JdbcComm();
        Statement statement = jdbc.getConnection().createStatement();

//        // Receive input from the user
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the book ID to mark as deleted: ");
//        int bookId = scanner.nextInt();
//        scanner.nextLine(); // Consume the newline character

        // Update the row with deletion information
        String updateQuery = "UPDATE t_book SET is_deleted = 'T', deleted_ts = CURRENT_TIMESTAMP WHERE book_id = " + bookId;
        int rowsAffected = statement.executeUpdate(updateQuery);

        if (rowsAffected > 0) {
            System.out.println("Book ID " + bookId + " marked as deleted.");
        } else {
            System.out.println("Book ID not found in the database.");
        }

        // Close resources
        statement.close();
        jdbc.getConnection();
//        scanner.close();
    }

    // Book의 제목, 내용, 저자 변경
    public void updateBook() throws SQLException {
        JdbcComm jdbc = new JdbcComm();
        Statement statement = jdbc.getConnection().createStatement();

        // Receive input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the book ID to edit: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Retrieve the row based on the book ID
        String query = "SELECT * FROM t_book WHERE book_id = " + bookId;
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            // Retrieve the existing values from the row
            String bookName = resultSet.getString("book_name");
            String author = resultSet.getString("author");
            String publisher = resultSet.getString("publisher");

            // Display the existing values to the user
            System.out.println("Existing Book Name: " + bookName);
            System.out.println("Existing Author: " + author);
            System.out.println("Existing Publisher: " + publisher);

            // Receive new values from the user
            System.out.print("Enter the new Book Name: ");
            String newBookName = scanner.nextLine();
            System.out.print("Enter the new Author: ");
            String newAuthor = scanner.nextLine();
            System.out.print("Enter the new Publisher: ");
            String newPublisher = scanner.nextLine();

            // Update the row with the new values
            String updateQuery = "UPDATE t_book SET book_name = '" + newBookName +
                    "', author = '" + newAuthor +
                    "', publisher = '" + newPublisher +
                    "' WHERE book_id = " + bookId;
            statement.executeUpdate(updateQuery);

            System.out.println("Row updated successfully!");
        } else {
            System.out.println("Book ID not found in the database.");
        }

        // Close resources
        resultSet.close();
        statement.close();
        jdbc.getConnection();
        scanner.close();
    }


    public int updateQty(Book book) throws SQLException {
        JdbcComm jdbc = new JdbcComm();
        Connection connection = jdbc.getConnection();
        // Update the row with the new values
        String updateQuery = "UPDATE t_book SET qty = ? WHERE book_id = ?";
        PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
        updateStatement.setInt(1, book.getQty());
        updateStatement.setInt(2, book.getBookId());
        int result = updateStatement.executeUpdate();
        updateStatement.close();
        jdbc.closeConnection();
        return result;
    }
}