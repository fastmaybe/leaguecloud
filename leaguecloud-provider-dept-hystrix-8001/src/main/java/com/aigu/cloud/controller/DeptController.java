package com.aigu.cloud.controller;

import com.aigu.cloud.entity.Dept;
import com.aigu.cloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 此为服务熔断  @HystrixCommand
 *
 * 服务熔断 和 服务降级比较
 *
 *
 * 第一点：
 *          服务熔断在服务端
 *          服务降级在客户端
 * 第二点：
 *          服务熔断 ： 注重于调用服务出现错误  返回fallback  解决服务扇形调用引起的服务雪崩；
 *          服务降级 ： 着重于 在某些情况下 比如服务器资源紧张 舍弃某些服务情况下（丢车保帅）
 *                      在客户端访问舍弃的服务（宕机）发现不可用时候  返回预设好的值（比如：服务升级,请稍后访问）
 */

@RestController
public class DeptController {

    @Resource
    private DeptService service;


    @PostMapping("/dept/add")
    public boolean add (@RequestBody Dept dept){
        return service.add(dept);
    }


    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrix_get")
    public Dept get(@PathVariable("id")Long id){
        Dept dept = service.get(id);
        if (null==dept){
            throw new RuntimeException("没有此数据");
        }
        return dept;
    }
    public Dept hystrix_get(@PathVariable("id")Long id){
        return new Dept().setDeptno(id).setName("服务熔断处理（服务端）").setDb_source("no mysql");
    }

    @GetMapping("/dept/list")
    public List<Dept> list(){
        return service.list();
    }

}
