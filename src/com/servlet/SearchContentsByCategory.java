package com.servlet;


import com.dao.ContentDao;
import com.dao.ContentDaoImpl;
import com.entity.Content;
import com.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchContentsByCategory extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String category = request.getParameter("Category");
        ContentDao contentDao = new ContentDaoImpl();

        List<Content> contents =  new ArrayList<>();
        if (Constant.PreciousCategory2.equals(category)) {
            if (request.getParameter("page") != null)
                Constant.ContentsCurrentPage = Integer.parseInt(request.getParameter("page"));
        }else{
            Constant.ContentsCurrentPage=1; Constant.ContentsTotalpage=0; Constant.TotalContents=0;
            Constant.PreciousCategory2=category;
        }
        if (category.equals("")) {
            contents = contentDao.getContentAll();
        } else {
            contents = contentDao.getContentByCategory(category);
        }
        contentDao.getCategoryNumber(category);

        request.setAttribute("userAll", contents);
        request.getRequestDispatcher("/showallcontents.jsp").forward(request, response);
    }
}
