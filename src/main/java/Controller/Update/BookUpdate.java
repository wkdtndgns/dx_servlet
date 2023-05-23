package Controller.Update;

import Dao.Book.Book;
import Service.Update.UpdateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class BookUpdate extends HttpServlet {
    UpdateService updateService = new UpdateService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Book book = updateService.getInfo(id);
            System.out.println("----book name----" + book.getBookName());
            req.setAttribute("book_name", book.getBookName());
//            req.setAttribute("category1", book.getCategory1());
//            req.setAttribute("category2", book.getCategory2());
            req.setAttribute("summary", book.getSummary());
            req.setAttribute("author", book.getAuthor());
            req.setAttribute("publisher", book.getPublisher());
            req.setAttribute("purchase_price", book.getPurchasePrice());
            req.setAttribute("selling_price", book.getSellingPrice());
            req.setAttribute("qty", book.getQty());
            req.setAttribute("page", book.getPage());
            req.getRequestDispatcher("/bookUpdate.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        Book book = new Book();
    }

}
