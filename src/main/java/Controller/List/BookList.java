package Controller.List;

import Dao.Book.Book;
import Service.List.ListService;
import Service.List.Vo.BookListParamVo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

public class BookList extends HttpServlet {

    final static int Limit = 10;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListService listService = new ListService();

        try {
            BookListParamVo blpv = new BookListParamVo();
            blpv.setSearch(request.getParameter("search"));
            blpv.setPage(request.getParameter("page"));
            blpv.setLimit(Limit);

            // 서비스 호출
            request.setAttribute("search", blpv.getSearch());
            request.setAttribute("bookPage", blpv.getPage());
            request.setAttribute("limit", blpv.getLimit());
            request.setAttribute("bookList", listService.getBookList(blpv));
            request.setAttribute("totalCount", listService.getBookTotal(blpv));
            request.getRequestDispatcher("/bookList.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
