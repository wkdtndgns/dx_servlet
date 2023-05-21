package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {
    private final UserRepository userRepository = UserRepository.getInstance();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String oldname = request.getParameter("oldid");
        String updatename = request.getParameter("updateid");

        userRepository.updateUser(oldname, updatename);

        response.setContentType("text/html; charset =utf-8");
        PrintWriter pw = response.getWriter();

        pw.println("<html>");
        pw.println("<head></head>");
        pw.println("<body>");
        pw.println(oldname + "아이디가 " + updatename + "로 성공적으로 수정되었습니다.<br/>");
        pw.println("<ul><li><a href='lists'> 회원목록 다시보기 </a> <br>");
//			pw.println("<li><a href='index.html'> 첫 화면으로 돌아가기 </a> </ul>");
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
//	        response.sendRedirect("lists");
    }
}
