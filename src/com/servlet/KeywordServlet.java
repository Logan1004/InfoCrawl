package com.servlet;

import com.dao.CompanyDao;
import com.dao.CompanyDaoImpl;
import com.dao.KeywordDao;
import com.dao.KeywordDaoImpl;
import com.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class KeywordServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("name") != null) {
            String keyword = request.getParameter("name");
            KeywordDao keywordDao = new KeywordDaoImpl();
            System.out.println("ren2");
            if (keyword.equals("")) {
                request.setAttribute("info", "关键词不能为空");
                request.getRequestDispatcher("addkey.jsp").forward(request, response);
            } else if (!keywordDao.CheckKeyWord(keyword)) {
                System.out.println("ren");
                request.setAttribute("info", "关键词重复");
                request.getRequestDispatcher("addkey.jsp").forward(request, response);
            } else if (keywordDao.InsertKeyword(keyword)) {
                request.setAttribute("info", "添加成功");
                request.getRequestDispatcher("addkey.jsp").forward(request, response);
            } else {
                response.sendRedirect("index.jsp");
            }
        }else{
            request.setAttribute("info", "关键词不能为空");
            request.getRequestDispatcher("addkey.jsp").forward(request, response);
        }
    }
}
