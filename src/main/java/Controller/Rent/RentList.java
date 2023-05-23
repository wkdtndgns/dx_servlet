package Controller.Rent;

import Dao.Book.Book;
import Service.Register.RegisterService;
import Service.Rent.RentService;
import Service.Review.ReviewService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RentList extends HttpServlet {

    RentService rentService = new RentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/rentList.html").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost rent call!!!!");
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("user_name");
        String bookName = request.getParameter("book_name");
        try {
            RentService.setRent(userName, bookName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("/rentListHistory");
    }
}