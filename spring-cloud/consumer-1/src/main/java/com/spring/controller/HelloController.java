package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by admin on 2018/11/1.
 */
@RestController
public class HelloController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/index" ,method = RequestMethod.GET)
    public String index(){
        List<String> serviceIdList = discoveryClient.getServices();
        System.out.println(serviceIdList);
        return "Hello World";
    }


    @RequestMapping(value = "/helloConsumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return restTemplate.getForEntity("http://localhost:8083/indexPost",String.class).getBody();
    }
}
