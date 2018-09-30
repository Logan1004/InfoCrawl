package com.util;

import com.entity.Keyword;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Constant {

    public static int EssayCurrentPage=1;
    public static int EssayTotalpage=0;
    public static int TotalEssays=0;
    public static String PreciousCategory="";

    public static int NewsCurrentPage=1;
    public static int NewsTotalpage=0;
    public static int TotalNews=0;
    public static String PreciousCategory1="";

    public static int ContentsCurrentPage=1;
    public static int ContentsTotalpage=0;
    public static int TotalContents=0;
    public static String PreciousCategory2="";


    public static List<Keyword> keywords = new ArrayList<>();

    public static boolean Initial(){
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from Keyword");
            while(rs.next()){
                Keyword keyword = new Keyword();
                keyword.setKeyword(rs.getString("Category"));
                keywords.add(keyword);
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}
