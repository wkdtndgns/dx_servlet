package Controller.Reivew;

import Dao.Book.Book;
import Dao.BookReivew.BookReview;
import Dao.BookReivew.BookReviewDao;
import Service.Update.UpdateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class InsertReview extends HttpServlet {

    UpdateService updateService = new UpdateService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Book book = updateService.getInfo(id);
            req.setAttribute("book_name", book.getBookName());
            System.out.println("북 리뷰 :" + book.getBookName());
            req.getRequestDispatcher("/postReview.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = new Book();
        try {
            book = updateService.getInfo(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String user_name = req.getParameter("user_name");
//        String book_name = req.getParameter("book_name");
//            int id = Integer.parseInt(req.getParameter("id"));
        int rate = Integer.parseInt(req.getParameter("rate"));
        String book_name = book.getBookName();
        BookReview bookReview = new BookReview(user_name, book_name, id, rate);

        try {
            int result = BookReviewDao.insert(bookReview);
            resp.sendRedirect("/reviewList");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

