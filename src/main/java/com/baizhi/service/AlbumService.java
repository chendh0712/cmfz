package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.Map;

public interface AlbumService {
    public Map<String,Object> getAll(Integer page,Integer rows);
    public Map<String,Object> add(Album album);
    public void updateCover(String id,String cover);
    public void update(Album album);
}
