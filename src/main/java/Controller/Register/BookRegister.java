package Controller.Register;

import Dao.Book.Book;
import Service.List.ListService;
import Service.List.Vo.BookListParamVo;
import Service.Register.RegisterService;
import Service.Register.Vo.RegisterBookVo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

public class BookRegister extends HttpServlet  {

    RegisterService registerService = new RegisterService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/bookRegister.html").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost call!!!!");
        request.setCharacterEncoding("utf-8");
        Book book = new Book();
        book.setCategory1(Integer.parseInt(request.getParameter("category1")));
        book.setCategory2(Integer.parseInt(request.getParameter("category2")));
        book.setBookName(request.getParameter("book_name") );
        book.setSummary(request.getParameter("summary") );
        book.setAuthor(request.getParameter("author") );
        book.setPublisher(request.getParameter("publisher") );
        book.setPurchasePrice(BigDecimal.valueOf(Double.parseDouble(request.getParameter("purchasePrice"))));
        book.setSellingPrice(BigDecimal.valueOf(Double.parseDouble(request.getParameter("sellingPrice"))));
        book.setQty(Integer.parseInt(request.getParameter("qty")));
        book.setPage(Integer.parseInt(request.getParameter("page")));
        try {
            registerService.setBookRegister(book);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("/bookList");
    }
}
