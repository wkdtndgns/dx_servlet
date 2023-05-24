package Controller.Recommned;

import Repository.RecommendRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RecommendList extends HttpServlet {

    private final RecommendRepository recommendRepository = RecommendRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", recommendRepository.getRepository());
        request.getRequestDispatcher("/recommendList.jsp").forward(request, response);
    }
}
