package com.example.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class deleteServlet extends HttpServlet {
    private final UserRepository userRepository = UserRepository.getInstance();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("id");
        response.setContentType("text/html;charset=utf-8");

        userRepository.deleteUser(name);

        response.sendRedirect("lists");
    }
}