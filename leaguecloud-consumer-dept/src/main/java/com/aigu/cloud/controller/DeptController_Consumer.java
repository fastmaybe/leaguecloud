package com.aigu.cloud.controller;

import com.aigu.cloud.entity.Dept;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptController_Consumer {

    private static final String  rest_url_pre="http://LEAGUECLOUD-DEPT";
//    private static final String  rest_url_pre="http://localhost:8001";

    @Resource
    private    RestTemplate restTemplate;

    @PostMapping("consumer/dept")
    public boolean add(Dept dept){
        return restTemplate.postForObject(rest_url_pre+"/dept/add",dept,Boolean.class);
    }

    @GetMapping("consumer/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        return restTemplate.getForObject(rest_url_pre+"/dept/get/"+id,Dept.class);
    }

    @SuppressWarnings(value = "unchecked")
    @GetMapping("consumer/dept/list")
    public List<Dept> get(){
        return restTemplate.getForObject(rest_url_pre+"/dept/list",List.class);
    }

}
