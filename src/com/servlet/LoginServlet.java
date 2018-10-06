package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("form-username");
        String pwd = request.getParameter("form-password");
        if (name.equals("admin") && pwd.equals("1234"))
        {
            request.setAttribute("logininfo", "success");
            request.getRequestDispatcher("test.jsp").forward(request, response);
        }
        else {
            request.setAttribute("logininfo", "fail");
            request.getRequestDispatcher("test.jsp").forward(request, response);
        }


    }
}
