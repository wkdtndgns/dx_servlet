package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

        response.setContentType("text/html; charset =utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8R\">");
        out.println("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css\">\n" +
                "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js\"></script>");

        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"bs-example col-sm-4\" style=\" margin: 20px;\" > ");
        out.println("<table class=\"table\" \"border:5px outset pink;\">\n" +
                "    <thead>\n" +
                "    <th>아이디</th>\n" +
                "    <th>삭제</th>\n" +
                "    <th>수정</th>\n" +
                "    </thead>\n" +
                "    <tbody>\n" +
                "\n" +
                "    </tbody>\n");

        LinkedList<User> userList = userRepository.getusers();

        for (User user : userList) {
            out.println("<tr>");
            out.println("<td>" + user.getName() + "</td>");
            out.println("<td><a href='deletes?id=" + user.getName() + "'>삭제</a></td>");

            out.println("<td>");
            out.println("<a href='update.html'" + user.getName() + ">수정</a>");

            out.println("</td>");

            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</div>");
        out.println("<br>");

        out.println("<div><a href='index.html'> 돌아가기 </a></div>");

        out.println("</body>");
        out.println("<html>");

        out.close();

    }

}
