package Controller.Reivew;

import Dao.Book.Book;
import Dao.Book.BookDao;
import Service.List.ListService;
import Service.Review.ReviewService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;

public class ReviewList extends HttpServlet  {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReviewService reviewService = new ReviewService();
        HashMap<String, Integer> map = new HashMap<>();

        try {
            map = reviewService.getMapNameRate();
            request.setAttribute("map", map);
            System.out.println(map);
            request.getRequestDispatcher("/bookListWithReview.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
