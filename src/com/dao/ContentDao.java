package com.dao;

import com.entity.Content;

import java.util.List;

public interface ContentDao {
    List<Content> getContentAll();
    List<Content> getContentByCategory(String Category);
    Boolean getNumber();
    Boolean getCategoryNumber(String Category);
}
