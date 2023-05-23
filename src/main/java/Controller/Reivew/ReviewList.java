package Controller.Reivew;

import Dao.Book.Book;
import Service.List.ListService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

public class ReviewList extends HttpServlet  {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListService listService = new ListService();

        try {
            LinkedList<Book> lb = listService.getBookList();
            request.setAttribute("bookList", lb);
            request.getRequestDispatcher("/bookList.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
