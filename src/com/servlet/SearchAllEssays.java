package com.servlet;

import com.dao.*;
import com.entity.Company;
import com.entity.Essay;
import com.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchAllEssays extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EssayDao essayDao = new EssayDaoImpl();
        if (Constant.PreciousCategory.equals("")) {
            if (request.getParameter("page") != null)
                Constant.EssayCurrentPage = Integer.parseInt(request.getParameter("page"));
        }else{
             Constant.EssayFlag=0;
             Constant.EssayCurrentPage=1; Constant.EssayTotalpage=0; Constant.TotalEssays=0;
             Constant.PreciousCategory="";
        }

        List<Essay> essays = essayDao.getEssayAll();
        System.out.println(Constant.EssayCurrentPage+"d21");
        essayDao.getNumber();


        //if (request.getParameter("Currentpage")==null) Constant.EssayCurrentPage=1;
        //else if (Integer.parseInt(request.getParameter("Currentpage"))==Constant.EssayTotalpage);
        //else Constant.EssayCurrentPage = Integer.parseInt(request.getParameter("Currentpage"));
        request.setAttribute("userAll", essays);
        request.getRequestDispatcher("/showallessays.jsp").forward(request, response);
    }
}
