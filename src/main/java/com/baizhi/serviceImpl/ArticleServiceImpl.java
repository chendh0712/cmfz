package com.baizhi.serviceImpl;

import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map<String, Object> getAll(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        Integer start=(page-1)*rows;
        List<Article> all = articleDao.getAll(start, rows);
        Integer records = articleDao.getCount();
        Integer total=records%rows==0?records/rows:records/rows+1;
        map.put("rows",all);
        map.put("total",total);
        map.put("records",records);
        map.put("page",page);


        return map;
    }
}
