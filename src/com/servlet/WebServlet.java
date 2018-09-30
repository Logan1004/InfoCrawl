package com.servlet;

import com.dao.KeywordDao;
import com.dao.KeywordDaoImpl;
import com.dao.WebDao;
import com.dao.WebDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class WebServlet  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String url = request.getParameter("url");
        String company = request.getParameter("company");
        String category = request.getParameter("category");
        WebDao webDao = new WebDaoImpl();
        url = url.trim();
        url = url.replaceAll("\\s*", "");

        System.out.println(url.charAt(0));
        if (url.charAt(0)!='h') url="http://"+url;

        System.out.println(url);
        if (company.equals("")) company="unknowned";

        if (url.equals("")){
            request.setAttribute("info", "url不能为空");
            request.getRequestDispatcher("addnews.jsp").forward(request, response);
        }
        else if (!webDao.CheckWeb(url)){
            System.out.println("ren");
            request.setAttribute("info", "关键词重复");
            request.getRequestDispatcher("addnews.jsp").forward(request, response);
        }
        else if (webDao.InsertWeb(company,url,category)){
            request.setAttribute("info", "添加成功");
            request.getRequestDispatcher("addnews.jsp").forward(request, response);
        }else{
            response.sendRedirect("index.jsp");
        }
    }
}
