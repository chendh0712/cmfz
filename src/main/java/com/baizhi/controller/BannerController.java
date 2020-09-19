package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @RequestMapping("edit")
    public Map<String,Object> edit(String oper, Banner banner,String[] id){
        if("add".equals(oper)){
            Map<String, Object> map = bannerService.add(banner);
            return map;
        }
        if("edit".equals(oper)){
            System.out.println(banner);
            bannerService.updateStatus(banner);
        }
        if("del".equals(oper)){
            bannerService.del(id);
        }
        return null;
    }

    @RequestMapping("upload")
    public void upload(String bannerId, MultipartFile imgPath, HttpSession session){
        //获取图片上传的路径
        System.out.println(bannerId);
        String realPath = session.getServletContext().getRealPath("/img");
        //
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }
        String filename = imgPath.getOriginalFilename();
        String newFileName = new Date().getTime() + "_" + filename;
        try {
            imgPath.transferTo(new File(realPath,newFileName));

        } catch (IOException e) {
            e.printStackTrace();
        }
        Banner banner = new Banner();
        banner.setId(bannerId);
        banner.setImgPath(newFileName);
        bannerService.update(banner);


    }

    @RequestMapping("/getAll")
    public Map<String,Object> getAll(Integer page,Integer rows){
        Map<String, Object> map = bannerService.getAll(page, rows);
        return map;
    }

    @RequestMapping("/out")
    public void getAll(HttpSession session, HttpServletResponse response){
        List<Banner> banners = bannerService.queryAll(session,response);
        System.out.println("导出完毕");
    }
}
