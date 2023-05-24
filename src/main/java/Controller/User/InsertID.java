package Controller.User;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertID extends HttpServlet {
    private final UserRepository userRepository = UserRepository.getInstance();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");

        response.setContentType("text/html;charset=utf-8");

        if (name == null || name.isEmpty()) {

        } else {
            userRepository.add(name);

        }

        response.sendRedirect("/lists");
    }
}
