package com.dao;

public interface WebDao {
    Boolean InsertWeb(String Company,String url,String Category);
    Boolean CheckWeb(String url);
}
