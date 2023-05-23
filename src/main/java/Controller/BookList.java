package Controller;

import Dao.Book.Book;
import Service.List.ListService;
import Service.List.Vo.BookListParamVo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

public class BookList extends HttpServlet {

    final static int Limit = 10;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListService listService = new ListService();

        try {
            BookListParamVo blpv = new BookListParamVo();
            String search = request.getParameter("search") == null ? "" : request.getParameter("search");
            blpv.setSearch(search);
            String Page = request.getParameter("page") == null ? "1" : request.getParameter("page");
            blpv.setPage(Integer.parseInt(Page));
            blpv.setLimit(10);

            // 서비스 호출
            request.setAttribute("bookPage", Integer.parseInt(Page));
            request.setAttribute("limit", Limit);
            request.setAttribute("bookList", listService.getBookList(blpv));
            request.setAttribute("totalCount", listService.getBookTotal());
            request.getRequestDispatcher("/bookList.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
