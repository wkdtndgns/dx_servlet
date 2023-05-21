package com.example.servlet;

import com.example.servlet.data.ServletList;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static LinkedList<ServletList> li;
    public static int id;
    public ListServlet() {
        super();
        System.out.println("생성자 콜");
    }

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset =utf-8");

        for (ServletList s : li)
            System.out.println(s);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }
}