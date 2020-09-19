package com.baizhi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("first")
public class TestController {
    @RequestMapping("first_page")
    public Map<String,Object> test(String uid,String type,String sub_type){

        return null;
    }
}
