package Controller.Rent;

import Dao.BookRent.BookRent;
import Service.Rent.RentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

public class RentListHistory extends HttpServlet {

    RentService rentService = new RentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LinkedList<BookRent> bookRents = RentService.getRentListHistory();
        for (BookRent br : bookRents) System.out.println(br);
        request.setAttribute("bookRentList", bookRents);
        request.getRequestDispatcher("/rentListHistory.jsp").forward(request, response);
    }
}