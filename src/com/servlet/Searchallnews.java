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
import java.util.List;

public class Searchallnews extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CompanyDao companyDao = new CompanyDaoImpl();
		if (Constant.PreciousCategory1.equals("")) {
			if (request.getParameter("page") != null)
				Constant.NewsCurrentPage = Integer.parseInt(request.getParameter("page"));
		}else{
			Constant.NewsFlag=0;
			Constant.NewsCurrentPage=1; Constant.NewsTotalpage=0; Constant.TotalNews=0;
			Constant.PreciousCategory1="";
		}
		List<Company> companies = companyDao.getCompanyAll();
		companyDao.getNumber();


		request.setAttribute("userAll", companies);
		request.getRequestDispatcher("/showallnews.jsp").forward(request, response);
	}
}
