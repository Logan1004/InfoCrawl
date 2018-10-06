package com.servlet;

import com.dao.CompanyDao;
import com.dao.CompanyDaoImpl;
import com.entity.Company;
import com.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchNewsByCategory extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String category = request.getParameter("Category");
        CompanyDao companyDao = new CompanyDaoImpl();
        if (Constant.finalNewsflag==1) Constant.NewsCategoryFlag=1;

        if (Constant.PreciousCategory1.equals(category)) {
            if (request.getParameter("page") != null)
                Constant.NewsCurrentPage = Integer.parseInt(request.getParameter("page"));
        }else{
            Constant.NewsCategoryFlag=1;
            Constant.NewsCurrentPage=1; Constant.NewsTotalpage=0; Constant.TotalNews=0;
            Constant.PreciousCategory1=category;
        }
        List<Company> companies = new ArrayList<>();
        if (category.equals("")) {
            Constant.NewsFlag=0;
            companies = companyDao.getCompanyAll();
        } else {
            companies = companyDao.getCompanyByCategory(category);
        }
        companyDao.getCategoryNumber(category);

        request.setAttribute("userAll", companies);
        request.getRequestDispatcher("/showallnews.jsp").forward(request, response);
    }
}
