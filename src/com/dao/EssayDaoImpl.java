package com.dao;

import com.entity.Essay;
import com.util.Constant;
import com.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EssayDaoImpl implements EssayDao {
    public List<Essay> getEssayAll() {
        List<Essay> list = new ArrayList<Essay>();

        int point = (Constant.EssayCurrentPage-1)*20+1;
        int temp = 20;
        if (point+20>Constant.TotalEssays){
            temp = Constant.TotalEssays-point+1;
        }
        System.out.println(Constant.EssayCurrentPage+" "+point+" "+temp);
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from EssayInfo limit "+point+","+temp);
            while(rs.next()){
                Essay essay = new Essay();
                essay.setDownloadUrl(rs.getString("DownloadUrl"));
                essay.setTitle(rs.getString("Title"));
                essay.setSourceOfArticle(rs.getString("SourceofArticle"));
                essay.setReference(rs.getString("Reference"));
                essay.setAuthor(rs.getString("Author"));
                essay.setAuthorCompany(rs.getString("AuthorCompany"));
                essay.setKeyWord(rs.getString("KeyWord"));
                essay.setArticleAbstract(rs.getString("Abstract"));
                essay.setDocuments(rs.getString("Documents"));
                essay.setCategory(rs.getString("Category"));
                list.add(essay);
            }

            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Essay> getEssayByCategory(String Category) {
        List<Essay> list = new ArrayList<Essay>();
        int point = (Constant.EssayCurrentPage-1)*20+1;
        int temp = 20;
        if (point+20>Constant.TotalEssays){
            temp = Constant.TotalEssays-point+1;
        }
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from EssayInfo where Category = '"+Category+"' limit "+point+","+temp);
            while(rs.next()){
                Essay essay = new Essay();
                essay.setDownloadUrl(rs.getString("DownloadUrl"));
                essay.setTitle(rs.getString("Title"));
                essay.setSourceOfArticle(rs.getString("SourceofArticle"));
                essay.setReference(rs.getString("Reference"));
                essay.setAuthor(rs.getString("Author"));
                essay.setAuthorCompany(rs.getString("AuthorCompany"));
                essay.setKeyWord(rs.getString("KeyWord"));
                essay.setArticleAbstract(rs.getString("Abstract"));
                essay.setDocuments(rs.getString("Documents"));
                essay.setCategory(rs.getString("Category"));
                list.add(essay);
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
            ResultSet rs2 = DBconn.selectSql("select count(*) from EssayInfo");
            if (rs2.next()) {
                Constant.TotalEssays = rs2.getInt(1);
                Constant.EssayTotalpage = rs2.getInt(1) / 20+1;
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
            ResultSet rs2 = DBconn.selectSql("select count(*) from EssayInfo where Category = '"+Category+"'");
            if (rs2.next()) {
                System.out.println("xxx");
                Constant.TotalEssays = rs2.getInt(1);
                Constant.EssayTotalpage = rs2.getInt(1) / 20+1;
            }
            System.out.println("xxx"+Constant.TotalEssays);
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
