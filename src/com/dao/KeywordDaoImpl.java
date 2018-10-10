package com.dao;

import com.entity.Keyword;
import com.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KeywordDaoImpl implements KeywordDao{

    public Boolean CheckKeyWord(String keyWord) {
        List<String> list = new ArrayList<String>();
        boolean flag = false;
        try {
            DBconn.init();
            System.out.println("111");
            ResultSet rs = DBconn.selectSql("select * from Keyword where Category = '"+keyWord+"'");
            System.out.println("222");
            if (rs.next()) flag=false;
            else flag=true;
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public Boolean InsertKeyword(String keyWord) {
        boolean flag = false;
        String sql = "insert into Keyword(ID,Category) values('1','"+keyWord+"')";
        DBconn.init();
        int rs = DBconn.addUpdDel(sql);
        if(rs>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    public List<Keyword> getKeyWordAll() {
        List<Keyword> list = new ArrayList<Keyword>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Keyword");
            while(rs.next()){
                Keyword keyword = new Keyword();
                keyword.setKeyword(rs.getString("Category"));
                list.add(keyword);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public Boolean DeleteKeyword(String keyWord) {
        boolean flag = false;
        String sql = "delete from Keyword where Category = '"+keyWord+"'";
        DBconn.init();
        int rs = DBconn.addUpdDel(sql);
        if(rs>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }
}
