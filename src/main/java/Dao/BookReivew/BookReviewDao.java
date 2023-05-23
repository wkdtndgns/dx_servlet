package Dao.BookReivew;

import Dao.Book.Book;
import Dao.Book.BookDao;
import Jdbc.JdbcComm;

import java.math.BigDecimal;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class BookReviewDao {

    public static int insert(BookReview bookReview) throws SQLException {
        JdbcComm jdbc = new JdbcComm();
        Connection connection = jdbc.getConnection();

        String insertQuery = "INSERT INTO book_review (user_name, book_name, book_id, rate) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setString(1, bookReview.getUser_name());
        statement.setString(2, bookReview.getBook_name());
        statement.setInt(3, bookReview.getBook_id());
        statement.setInt(4, bookReview.getRate());

        int result = statement.executeUpdate();
        statement.close();
        jdbc.closeConnection();

        return result;
    }

    // Get average rating for each book name
    public static HashMap<String, Integer> getRate() throws SQLException {
        JdbcComm jdbc = new JdbcComm();
        Statement statement = jdbc.getConnection().createStatement();
        ResultSet resultSet = null;
        HashMap<String, Integer> map = new HashMap<>();
        String query = "SELECT DISTINCT book_name FROM t_book";
        LinkedList<String> liBook = new LinkedList<>();

        try {
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                liBook.add(resultSet.getString("book_name"));
            }

            for (String bookName : liBook) {
                query = "SELECT`` AVG(rate) AS avg FROM book_review WHERE book_name = '" + bookName + "'";
                resultSet = statement.executeQuery(query);
                if (resultSet.next()) {
                    map.put(bookName, resultSet.getInt("avg"));
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error executing SQL query: " + query, e);
        } finally {
            // Close ResultSet, Statement, and Connection
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            jdbc.closeConnection();
        }
        resultSet.close();
        statement.close();
        jdbc.closeConnection();
        return map;
    }
}

