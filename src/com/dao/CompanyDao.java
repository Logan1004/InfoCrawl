package com.dao;

import com.entity.Company;

import java.util.List;

public interface CompanyDao {
    List<Company> getCompanyAll();
    boolean update(String company, String url, String category, String content) ;
    boolean delete(String url) ;
    List<Company> getCompanyByCategory(String Category);
    Boolean getNumber();
    Boolean getCategoryNumber(String Category);
}
