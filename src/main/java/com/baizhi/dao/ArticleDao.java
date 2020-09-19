package com.baizhi.dao;

import com.baizhi.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao {
    public List<Article> getAll(@Param("start") Integer start, @Param("rows") Integer rows);
    public Integer getCount();
}
