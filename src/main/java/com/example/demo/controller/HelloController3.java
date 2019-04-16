package com.example.demo.controller;

import com.example.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("param")
public class HelloController3 {

    @Autowired
    private GirlProperties girlProperties;

    // param/say/name
    @RequestMapping(value = "/say/{name}", method = RequestMethod.GET)
    public String say(@PathVariable("name") String name){
        // 获取路由{name}
        return name + " like " + girlProperties.getCupSize();
    }

    // param/say?name=100
    @RequestMapping(value = "/say2", method = RequestMethod.GET)
    public String say2(@RequestParam(value = "name", required = false, defaultValue = "le") String name){
        // required是否必须有参数，defaultValue默认参数
        return name + " like " + girlProperties.getCupSize();
    }

    @GetMapping(value = "/say3")
    // 等同于@RequestMapping(value = "/say3", method = RequestMethod.GET)
    public String say3(@RequestParam(value = "name", required = false, defaultValue = "le") String name){
        // required是否必须有参数，defaultValue默认参数
        return name + " like " + girlProperties.getCupSize();
    }
}
