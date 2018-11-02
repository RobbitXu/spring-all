package com.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2018/11/1.
 */
@RestController
public class HelloContorller {

    @RequestMapping(value = "/indexPost",method = RequestMethod.POST)
    public String indexPost(){
        return "indexPost";
    }

    @RequestMapping(value = "/indexGet",method = RequestMethod.GET)
    public String indexGet(){
        return "indexGet";
    }
}
