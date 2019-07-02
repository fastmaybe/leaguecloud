package com.aigu.cloud.controller;

import com.aigu.cloud.entity.Dept;
import com.aigu.cloud.service.DeptService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptController {

    @Resource
    private DeptService service;


    @PostMapping("/dept/add")
    public boolean add (@RequestBody Dept dept){
        return service.add(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        return service.get(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list(){
        return service.list();
    }

}
