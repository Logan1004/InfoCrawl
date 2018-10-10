package com.servlet;

import com.dao.KeywordDao;
import com.dao.KeywordDaoImpl;
import com.dao.WebDao;
import com.dao.WebDaoImpl;
import com.entity.Keyword;
import com.util.Constant;

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

        Constant.ContentFlag=1;
        Constant.NewsFlag=1;
        Constant.EssayFlag=1;
        String url = request.getParameter("url");
        String company = request.getParameter("company");
        String category = request.getParameter("category");
        WebDao webDao = new WebDaoImpl();
        KeywordDao keywordDao = new KeywordDaoImpl();

        System.out.println(url);
        if (company.equals("")) company="unknowned";
        if (category.equals("")){
            request.setAttribute("webinfo", "关键词不能为空");
            request.getRequestDispatcher("addkey.jsp").forward(request, response);
        }else {
            if (keywordDao.CheckKeyWord(category)){
                request.setAttribute("webinfo", "关键词不存在");
                request.getRequestDispatcher("addkey.jsp").forward(request, response);
            }else {
                if (url.equals("")) {
                    request.setAttribute("webinfo", "url不能为空");
                    request.getRequestDispatcher("addkey.jsp").forward(request, response);
                } else {
                    url = url.trim();
                    url = url.replaceAll("\\s*", "");
                    System.out.println(url.charAt(0));
                    if (url.charAt(0) != 'h') url = "http://" + url;

                    if (!webDao.CheckWeb(url)) {
                        System.out.println("ren");
                        request.setAttribute("webinfo", "url重复");
                        request.getRequestDispatcher("addkey.jsp").forward(request, response);
                    } else if (webDao.InsertWeb(company, url, category)) {
                        request.setAttribute("webinfo", "添加成功");
                        request.getRequestDispatcher("addkey.jsp").forward(request, response);
                    } else {
                        response.sendRedirect("index.jsp");
                    }
                }
            }
        }
    }
}
