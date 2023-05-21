package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertID extends HttpServlet {
    private final UserRepository userRepository = UserRepository.getInstance();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("id");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();

        if (name == null || name.isEmpty()) {
            pw.println("<html>");
            pw.println("<head></head>");
            pw.println("<body>");
            pw.println("실패<br/>");
            pw.println("<a href='index.html'> 돌아가기 </a>");
            pw.println("</body>");
            pw.println("</html>");

        } else {
            userRepository.add(name);
            pw.println("<html>");
            pw.println("<head></head>");
            pw.println("<body>");
            pw.println(name + "님! 성공적으로 가입되었습니다.<br/>");
            pw.println("<a href='index.html'> 돌아가기 </a>");
            pw.println("</body>");
            pw.println("</html>");
        }

        pw.close();
    }
}
