
package com.inus.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inus.ms.entities.Dept;

@ FeignClient(value = "MSPROVIDER")
public interface DeptConsumerService
{

    @ RequestMapping(value = "/dept/add")
    public boolean add(Dept dept);

    @ RequestMapping(value = "/dept/get/{no}")
    public Dept get(@ RequestParam("no") int no);

    @ RequestMapping(value = "/dept/list")
    public List<Dept> list();
}
