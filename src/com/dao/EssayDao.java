package com.dao;

import com.entity.Essay;

import java.util.List;

public interface EssayDao {
    List<Essay> getEssayAll();
    List<Essay> getEssayByCategory(String Category);
    Boolean getNumber();
    Boolean getCategoryNumber(String Category);
}
