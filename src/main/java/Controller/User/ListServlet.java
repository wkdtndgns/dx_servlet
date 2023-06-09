package Controller.User;

import Repository.UserRepository;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListServlet extends HttpServlet {

    private final UserRepository userRepository = UserRepository.getInstance();

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        LinkedList<User> userList = userRepository.getusers();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }
}
