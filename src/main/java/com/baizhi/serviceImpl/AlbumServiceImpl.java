package com.baizhi.serviceImpl;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> getAll(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        Integer begin=(page-1)*rows;
        List<Album> list = albumDao.getAll(begin, rows);
        Integer records = albumDao.getCount();
        Integer total=records%rows==0?records/rows:records/rows+1;
        map.put("rows",list);
        map.put("records",records);
        map.put("total",total);
        map.put("page",page);

        return map;
    }

    @Override
    public Map<String, Object> add(Album album) {
        Map<String, Object> map = new HashMap<>();
        album.setId(UUID.randomUUID().toString());
        album.setScore(0.0);
        album.setCount(70);
        album.setPublishDate(new Date());
        albumDao.add(album);
        String id = album.getId();
        map.put("id",id);
        return map;
    }

    @Override
    public void updateCover(String id, String cover) {
        albumDao.updateCover(id,cover);
    }

    @Override
    public void update(Album album) {
        albumDao.update(album);
    }
}
