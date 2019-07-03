package com.aigu.cloud.controller;

import com.aigu.cloud.entity.Dept;
import com.aigu.cloud.service.DeptClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * 消费者  使用feigin(自带ribbon负载均衡 轮询)
 * 面向接口调用微服务
 */
@RestController
public class DeptController_Consumer {


    @Resource
    private DeptClientService service;
//    private static final String  rest_url_pre="http://LEAGUECLOUD-DEPT";
//    private static final String  rest_url_pre="http://localhost:8001";

//    @Resource
//    private    RestTemplate restTemplate;

    @PostMapping("consumer/dept")
    public boolean add(Dept dept){
//        return restTemplate.postForObject(rest_url_pre+"/dept/add",dept,Boolean.class);
        return  service.add(dept);
    }

    @GetMapping("consumer/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
//        return restTemplate.getForObject(rest_url_pre+"/dept/get/"+id,Dept.class);
        return  service.get(id);
    }

    @SuppressWarnings(value = "unchecked")
    @GetMapping("consumer/dept/list")
    public List<Dept> list(){
//        return restTemplate.getForObject(rest_url_pre+"/dept/list",List.class);
        return service.list();
    }

}
