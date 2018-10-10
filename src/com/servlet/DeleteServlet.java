package com.servlet;

import com.dao.CompanyDao;
import com.dao.CompanyDaoImpl;
import com.dao.KeywordDao;
import com.dao.KeywordDaoImpl;

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


		if (request.getParameter("delename") != null) {
			String keyword = request.getParameter("delename");
			if (keyword.equals("医疗器械") || keyword.equals("区块链") || keyword.equals("人工智能") || keyword.equals("新兴产业")){
				request.setAttribute("deleteinfo", "默认关键词不能删除");
				request.getRequestDispatcher("addkey.jsp").forward(request, response);
			}else {
				KeywordDao keywordDao = new KeywordDaoImpl();
				System.out.println(keyword);
				if (keyword.equals("")){
					request.setAttribute("deleteinfo", "关键词不能为空");
					request.getRequestDispatcher("addkey.jsp").forward(request, response);
				} else if (keywordDao.CheckKeyWord(keyword)) {
					System.out.println("ren");
					request.setAttribute("deleteinfo", "关键词不存在");
					request.getRequestDispatcher("addkey.jsp").forward(request, response);
				} else if (keywordDao.DeleteKeyword(keyword)) {
					request.setAttribute("deleteinfo", "删除成功");
					request.getRequestDispatcher("addkey.jsp").forward(request, response);
				} else {
					response.sendRedirect("index.jsp");
				}
			}
		}else {
			System.out.println("关键词不能为空");
			request.setAttribute("deleteinfo", "关键词不能为空");
			request.getRequestDispatcher("addkey.jsp").forward(request, response);
		}
	}
}
