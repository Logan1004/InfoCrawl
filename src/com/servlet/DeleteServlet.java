package com.servlet;

import com.dao.CompanyDao;
import com.dao.CompanyDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String url = request.getParameter("Url");
		CompanyDao companyDao = new CompanyDaoImpl();

		if(companyDao.delete(url)){
			request.setAttribute("xiaoxi", "删除成功");
			request.getRequestDispatcher("/Searchallnews").forward(request, response);
		}else{
			response.sendRedirect("index.jsp");
		}
	}

}
