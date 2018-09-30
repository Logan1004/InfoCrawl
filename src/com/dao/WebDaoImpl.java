package com.dao;

import com.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WebDaoImpl implements WebDao {

    public Boolean CheckWeb(String url) {
        List<String> list = new ArrayList<String>();
        boolean flag = false;
        try {
            DBconn.init();
            System.out.println("333");
            ResultSet rs = DBconn.selectSql("select * from NewsCompanyInfo where Url = '"+url+"'");

            System.out.println("select * from NewsCompanyInfo where Url = '"+url+"'");
            if (rs.next()) flag=false;
            else flag=true;
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public Boolean InsertWeb(String Company, String url, String Category) {
        boolean flag = false;
        String sql = "insert into NewsCompanyInfo(Company,Url,Category) values('"+Company+"','"+url+"','"+Category+"')";
        DBconn.init();
        int rs = DBconn.addUpdDel(sql);
        if(rs>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }
}
