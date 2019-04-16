package com.example.demo.controller;

import com.example.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController //等同于@ResponseBody + @Controller
// @Controller
// @ResponseBody
@RequestMapping("/hi")  //前置路由：/hi
public class HelloController {

    @Value("${name}")
    private String name;

    @Autowired
    private GirlProperties girlProperties;

    // 路由：/hello 或者 /hi
    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    public String say() {
        return name + girlProperties.getCupSize();
    }
}
