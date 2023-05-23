package Controller.Delete;

import Dao.Book.BookDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class BookDelete extends HttpServlet {
    static BookDao bookDao = new BookDao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            bookDao.deleted(id);
            resp.sendRedirect("bookList");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
