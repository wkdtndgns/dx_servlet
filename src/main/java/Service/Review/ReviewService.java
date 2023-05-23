package Service.Review;

import Dao.Book.*;
import Dao.BookReivew.BookReview;
import Dao.BookReivew.BookReviewDao;

import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class ReviewService {
    static BookReviewDao bookReviewDao = new BookReviewDao();


    public HashMap<String, Integer> getMapNameRate() throws SQLException {
        return bookReviewDao.getRate();
    }
}
