package com.dao;

import com.entity.Keyword;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.security.Key;
import java.util.List;

public interface KeywordDao {
    Boolean InsertKeyword(String keyWord);
    Boolean CheckKeyWord(String keyWord);
    List<Keyword> getKeyWordAll();
}
