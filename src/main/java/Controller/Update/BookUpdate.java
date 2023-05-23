package Controller.Update;

import Dao.Book.Book;
import Service.Update.UpdateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

public class BookUpdate extends HttpServlet {
    UpdateService updateService = new UpdateService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Book book = updateService.getInfo(id);
            req.setAttribute("book_name", book.getBookName());
            req.setAttribute("category_1", book.getCategory1());
            req.setAttribute("category_2", book.getCategory2());
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get the data passed from the form
        String category1Param = request.getParameter("category1");
        int category1 = (category1Param != null && !category1Param.isEmpty()) ? Integer.parseInt(category1Param) : 0;

        String category2Param = request.getParameter("category2");
        int category2 = (category2Param != null && !category2Param.isEmpty()) ? Integer.parseInt(category2Param) : 0;

        String bookName = request.getParameter("book_name");
        String summary = request.getParameter("summary");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");

        String purchasePriceParam = request.getParameter("purchasePrice");
        BigDecimal purchasePrice = (purchasePriceParam != null && !purchasePriceParam.isEmpty()) ? new BigDecimal(purchasePriceParam) : BigDecimal.ZERO;

        String sellingPriceParam = request.getParameter("sellingPrice");
        BigDecimal sellingPrice = (sellingPriceParam != null && !sellingPriceParam.isEmpty()) ? new BigDecimal(sellingPriceParam) : BigDecimal.ZERO;

        String qtyParam = request.getParameter("qty");
        int qty = (qtyParam != null && !qtyParam.isEmpty()) ? Integer.parseInt(qtyParam) : 0;

        String pageParam = request.getParameter("page");
        int page = (pageParam != null && !pageParam.isEmpty()) ? Integer.parseInt(pageParam) : 0;

        // Create Book object and set data
        Book book = new Book();
        book.setCategory1(category1);
        book.setCategory2(category2);
        book.setBookName(bookName);
        book.setSummary(summary);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setPurchasePrice(purchasePrice);
        book.setSellingPrice(sellingPrice);
        book.setQty(qty);
        book.setPage(page);

        // Update book information using UpdateService
        try {
            updateService.update(book, 1);
            // If book modification is successful, move to the page containing the success message
            response.sendRedirect("/bookList");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
