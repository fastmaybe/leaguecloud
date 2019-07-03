package com.aigu.cloud.service;

import com.aigu.cloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 如何理解feigin
 *
 * @FeignClient 类似于@Mapper (猜想  使用代理实现 包装为http访问 微服务LEAGUECLOUD-DEPT )
 */

@FeignClient(value = "LEAGUECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {


    @PostMapping("/dept/add")
    public boolean add (@RequestBody Dept dept);

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id);

    @GetMapping("/dept/list")
    public List<Dept> list();
}
