package Controller.Recommned;

import Dao.Book.Book;
import Dao.Book.BookDao;
import Dao.BookReivew.BookReview;
import Dao.BookReivew.BookReviewDao;
import Service.List.ListService;
import Service.Recommend.RecommendService;
import Service.Rent.RentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Recommend extends HttpServlet {

    RecommendService recommendService = new RecommendService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/recommend.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("bookId"));

        String keyword = req.getParameter("keyword");
        Map<String, String> keyMap = new HashMap<>();
        for (String s : keyword.split(",")) {
            String[] arr = s.split(":");
            arr[1] = arr[1].trim();
            System.out.println(arr[1]);
            System.out.println(Arrays.toString(arr));

            keyMap.put(arr[0], arr[1].trim());
        }


        for (Map.Entry<String, String> entry : keyMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ": " + value);
        }
        BookRecommend bookRecommend = new BookRecommend();
        bookRecommend.setBookId(id);
        bookRecommend.setKeyMap(keyMap);
        try {
            recommendService.setRecommend(bookRecommend);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("/recommendList");
    }
}
