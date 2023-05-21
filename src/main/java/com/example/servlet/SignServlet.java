package com.example.servlet;

import com.example.servlet.data.ServletList;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sign")
public class SignServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public SignServlet() {
        super();
        System.out.println("생성자 콜");
    }

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset =utf-8");

        request.getRequestDispatcher("/sign.jsp").forward(request, response);
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        ListServlet.li.add(new ServletList(ListServlet.id, name));
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}