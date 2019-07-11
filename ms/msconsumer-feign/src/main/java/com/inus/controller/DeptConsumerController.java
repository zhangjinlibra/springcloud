
package com.inus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inus.ms.entities.Dept;
import com.inus.service.DeptConsumerService;

@ RestController
public class DeptConsumerController
{

    @ Autowired
    private DeptConsumerService consumerService;;

    @ ResponseBody
    @ RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept)
    {
        return consumerService.add(dept);
    }

    @ ResponseBody
    @ RequestMapping(value = "/consumer/dept/get/{no}")
    public Dept get(@ PathVariable("no") int no)
    {
        return consumerService.get(no);
    }

    @ ResponseBody
    @ RequestMapping(value = "/consumer/dept/list"/* , produces = {"application/json;charset=UTF-8"} */)
    public List<Dept> list()
    {
        return consumerService.list();
    }

}
