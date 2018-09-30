package com.dao;

import com.entity.Company;
import com.util.Constant;
import com.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDaoImpl implements CompanyDao{
    public List<Company> getCompanyAll() {
        List<Company> list = new ArrayList<Company>();
        int point = (Constant.NewsCurrentPage-1)*20+1;
        int temp = 20;
        if (point+20>Constant.TotalNews){
            temp = Constant.TotalNews-point+1;
        }
        try {
            DBconn.init();

            ResultSet rs = DBconn.selectSql("select * from NewsInfoTable order by CurTime desc limit "+point+","+temp);
            while(rs.next()){
                Company company = new Company();
                company.setCompany(rs.getString("Company"));
                company.setContent(rs.getString("Content"));
                company.setCategory(rs.getString("Category"));
                company.setUrl(rs.getString("Url"));
                company.setCurtime(rs.getString("CurTime"));
                list.add(company);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean update(String company , String url , String category, String content) {
        boolean flag = false;
        DBconn.init();
        String sql ="update NewsInfoTable set Company ='"+company
                +"' , Category ='"+category
                +"' , Content ='"+content+"' where Url = "+url;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }
    public boolean delete(String url) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete from NewsInfoTable where url="+url;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    public List<Company> getCompanyByCategory(String Category) {
        List<Company> list = new ArrayList<Company>();
        int point = (Constant.NewsCurrentPage-1)*20+1;
        int temp = 20;
        if (point+20>Constant.TotalNews){
            temp = Constant.TotalNews-point+1;
        }
        try {
            DBconn.init();

            ResultSet rs = DBconn.selectSql("select * from NewsInfoTable where Category = '"+Category+"' order by CurTime desc limit "+point+","+temp);
            while(rs.next()){
                Company company = new Company();
                company.setCompany(rs.getString("Company"));
                company.setContent(rs.getString("Content"));
                company.setCategory(rs.getString("Category"));
                company.setUrl(rs.getString("Url"));
                company.setCurtime(rs.getString("CurTime"));
                list.add(company);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean getNumber(){
        try {
            DBconn.init();
            ResultSet rs2 = DBconn.selectSql("select count(*) from NewsInfoTable");
            if (rs2.next()) {
                Constant.TotalNews = rs2.getInt(1);
                Constant.NewsTotalpage = rs2.getInt(1) / 20+1;
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public Boolean getCategoryNumber(String Category) {
        try {
            DBconn.init();
            ResultSet rs2 = DBconn.selectSql("select count(*) from NewsInfoTable where Category = '"+Category+"'");
            if (rs2.next()) {
                Constant.TotalNews = rs2.getInt(1);
                Constant.NewsTotalpage = rs2.getInt(1) / 20+1;
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}
