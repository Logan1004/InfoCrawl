package com.servlet;

import com.dao.CompanyDao;
import com.dao.CompanyDaoImpl;
import com.dao.EssayDao;
import com.dao.EssayDaoImpl;
import com.entity.Company;
import com.entity.Essay;
import com.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.event.ContainerAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchEssayByCategory extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String category = request.getParameter("Category");
        if (Constant.finalEssayflag==1) Constant.EssayCategoryFlag=1;
        EssayDao essayDao = new EssayDaoImpl();
        List<Essay> essays = new ArrayList<>();
        if (Constant.PreciousCategory.equals(category)) {
            if (request.getParameter("page") != null)
                Constant.EssayCurrentPage = Integer.parseInt(request.getParameter("page"));
        }else{
            Constant.EssayCategoryFlag=1;
            Constant.EssayCurrentPage=1; Constant.EssayTotalpage=0; Constant.TotalEssays=0;
            Constant.PreciousCategory=category;
        }
        if (category.equals("")) {
            Constant.EssayFlag=0;
            essays = essayDao.getEssayAll();
        } else {
            essays = essayDao.getEssayByCategory(category);
        }
        essayDao.getCategoryNumber(category);
        request.setAttribute("userAll", essays);
        request.getRequestDispatcher("/showallessays.jsp").forward(request, response);
    }
}
