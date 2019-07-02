package com.aigu.cloud.service;

import com.aigu.cloud.entity.Dept;

import java.util.List;

public interface DeptService {


    public boolean add(Dept dept);

    public Dept get(Long id);


    public List<Dept> list();
}
