package com.baizhi.serviceImpl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;
    @Override
    public Map<String, Object> getAll(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        Integer begin=(page-1)*rows;
        List<Banner> list = bannerDao.getAll(begin, rows);
        Integer count = bannerDao.getCount();
        Integer total=count%rows==0?count/rows:count/rows+1;
        map.put("rows",list);
        map.put("total",total);
        map.put("records",count);
        map.put("page",page);

        //total  总页数
        //page   page
        //records 总条数
        //rows   数据集合

        return map;
    }

    @Override
    public Map<String, Object> add(Banner banner) {
        Map<String, Object> map = new HashMap<>();
        banner.setId(UUID.randomUUID().toString().replace("-",""));
        banner.setCreateDate(new Date());
        bannerDao.add(banner);
        String id = banner.getId();
        map.put("id",id);
        return map;
    }

    @Override
    public void update(Banner banner) {
        bannerDao.update(banner);
    }

    @Override
    public void updateStatus(Banner banner) {
        bannerDao.updateStatus(banner);
    }

    @Override
    public void del(String[] id) {
        bannerDao.del(id);
    }

    @Override
    public List<Banner> queryAll(HttpSession session, HttpServletResponse response) {
        String realPath = session.getServletContext().getRealPath("/img/");
        List<Banner> banners = bannerDao.queryAll();
        for (Banner banner : banners) {
            String imgPath = banner.getImgPath();
            banner.setImgPath(realPath+imgPath);
        }


        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("轮播图列表", "图片"),
                Banner.class, banners);

        try {
            String encode = URLEncoder.encode("轮播图.xls", "UTF-8");
            response.setHeader("content-disposition","attachment;filename="+encode);
            ServletOutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
