package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDao {
    public List<Banner> getAll(@Param("begin") Integer begin, @Param("rows") Integer rows);
    public Integer getCount();
    public void add(Banner banner);
    public void update(Banner banner);
    public void updateStatus(Banner banner);
    public void del(String[] id);
    public List<Banner> queryAll();
}
