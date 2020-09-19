package com.baizhi.service;

import com.baizhi.entity.Banner;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface BannerService {
    public Map<String,Object> getAll(Integer page,Integer rows);
    public Map<String,Object> add(Banner banner);
    public void update(Banner banner);
    public void updateStatus(Banner banner);
    public void del(String[] id);
    public List<Banner> queryAll(HttpSession session, HttpServletResponse response);
}
