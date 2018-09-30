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
import java.util.List;

public class SearchAllContent extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ContentDao contentDao = new ContentDaoImpl();

        if (Constant.PreciousCategory2.equals("")) {
            if (request.getParameter("page") != null)
                Constant.ContentsCurrentPage = Integer.parseInt(request.getParameter("page"));
        }else{
            Constant.ContentsCurrentPage=1; Constant.ContentsTotalpage=0; Constant.TotalContents=0;
            Constant.PreciousCategory2="";
        }


        List<Content> contents = contentDao.getContentAll();
        //System.out.println(contents.get(1).getTitle());
        contentDao.getNumber();

        request.setAttribute("userAll", contents);
        request.getRequestDispatcher("/showallcontents.jsp").forward(request, response);
    }
}
