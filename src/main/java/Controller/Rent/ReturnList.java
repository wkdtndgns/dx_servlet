package Controller.Rent;

import Service.Rent.RentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ReturnList  extends HttpServlet {

    RentService rentService = new RentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/returnList.html").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost return call!!!!");
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("user_name");
        String bookName = request.getParameter("book_name");
        try {
            RentService.setReturn(userName, bookName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("/rentListHistory");
    }
}