package com.servlet;

import com.dao.CompanyDao;
import com.dao.CompanyDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String company = request.getParameter("Company");
		String url = request.getParameter("Url");
		String category = request.getParameter("Category");
		String content = request.getParameter("Content");

		CompanyDao companyDao = new CompanyDaoImpl();
		
		if(companyDao.update(company,url,category,content)){
			request.setAttribute("xiaoxi", "更新成功");
			request.getRequestDispatcher("/Searchallnews").forward(request, response);
		}else{
			response.sendRedirect("index.jsp");
		}
	}
}
