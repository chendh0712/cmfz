package com.baizhi.controller;

import com.baizhi.entity.EchartsMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("echarts")
public class EchartsController {
    @RequestMapping("test")
    public List<Integer> test(){
        List<Integer> list = new ArrayList<>();
        list.add(new Random().nextInt(1000));
        list.add(new Random().nextInt(1000));
        list.add(new Random().nextInt(1000));
        list.add(new Random().nextInt(1000));
        list.add(new Random().nextInt(1000));
        list.add(new Random().nextInt(1000));
        return list;
    }

    @RequestMapping("testMap")
    public List<EchartsMap> testmap(){
        List<EchartsMap> list = new ArrayList<>();

        EchartsMap echartsMap = new EchartsMap("北京", new Random().nextInt(1000));
        EchartsMap echartsMap2 = new EchartsMap("天津", new Random().nextInt(1000));
        EchartsMap echartsMap3 = new EchartsMap("河南", new Random().nextInt(1000));
        EchartsMap echartsMap4 = new EchartsMap("河北", new Random().nextInt(1000));
        EchartsMap echartsMap5 = new EchartsMap("山西", new Random().nextInt(1000));
        EchartsMap echartsMap6 = new EchartsMap("山东", new Random().nextInt(1000));
        EchartsMap echartsMap7 = new EchartsMap("江苏", new Random().nextInt(1000));
        EchartsMap echartsMap8 = new EchartsMap("浙江", new Random().nextInt(1000));

        list.add(echartsMap);
        list.add(echartsMap2);
        list.add(echartsMap3);
        list.add(echartsMap4);
        list.add(echartsMap5);
        list.add(echartsMap6);
        list.add(echartsMap7);
        list.add(echartsMap8);
        return list;
    }
}
