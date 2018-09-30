package com.servlet;

import com.dao.KeywordDao;
import com.dao.KeywordDaoImpl;
import com.entity.Keyword;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchAllKeywordsEssay extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        KeywordDao keywordDao = new KeywordDaoImpl();
        List<Keyword> keyword = keywordDao.getKeyWordAll();

        request.setAttribute("keywords", keyword);
        request.getRequestDispatcher("/showallessays.jsp").forward(request, response);
    }
}
