package com.example.demo.controller;

import com.example.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController2 {

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String say() {
//        return girlProperties.getContent();
        //使用模板，thymeleaf引擎
        return "index";
    }
}
