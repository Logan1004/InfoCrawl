package com.dao;

import com.entity.Content;
import com.util.Constant;
import com.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContentDaoImpl implements ContentDao{
    public List<Content> getContentAll() {
        List<Content> list = new ArrayList<Content>();
        int point = (Constant.ContentsCurrentPage-1)*20+1;
        int temp = 20;
        if (point+20>Constant.TotalContents){
            temp = Constant.TotalContents-point+1;
        }
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Application limit "+point+","+temp);
            while(rs.next()){
                Content content = new Content();
                content.setTitle(rs.getString("Title"));
                content.setCategory(rs.getString("Category"));
                content.setApplyTime(rs.getString("ApplyTime"));
                content.setAnnounceTime(rs.getString("AnnounceTime"));
                content.setOwner(rs.getString("Owner"));
                content.setDetail(rs.getString("Content"));
                content.setUrl(rs.getString("Url"));
                list.add(content);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Content> getContentByCategory(String Category) {
        List<Content> list = new ArrayList<Content>();
        int point = (Constant.ContentsCurrentPage-1)*20+1;
        int temp = 20;
        if (point+20>Constant.TotalContents){
            temp = Constant.TotalContents-point+1;
        }
        try {
            DBconn.init();

            ResultSet rs = DBconn.selectSql("select * from Application where Category = '"+Category+"' limit "+point+","+temp);
            while(rs.next()){
                Content content = new Content();
                content.setTitle(rs.getString("Title"));
                content.setCategory(rs.getString("Category"));
                content.setApplyTime(rs.getString("ApplyTime"));
                content.setAnnounceTime(rs.getString("AnnounceTime"));
                content.setOwner(rs.getString("Owner"));
                content.setDetail(rs.getString("Content"));
                content.setUrl(rs.getString("Url"));
                list.add(content);
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
            ResultSet rs2 = DBconn.selectSql("select count(*) from Application");
            if (rs2.next()) {
                Constant.TotalContents = rs2.getInt(1);
                Constant.ContentsTotalpage = rs2.getInt(1) / 20+1;
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
            ResultSet rs2 = DBconn.selectSql("select count(*) from Application where Category = '"+Category+"'");
            if (rs2.next()) {
                Constant.TotalContents = rs2.getInt(1);
                Constant.ContentsTotalpage = rs2.getInt(1) / 20+1;
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}
