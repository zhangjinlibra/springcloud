
package com.inus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.inus.ms.entities.Dept;

@ RestController
public class DeptConsumerController
{

    @ Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PROFIX = "http://localhost:8001";

    @ RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept)
    {
        return restTemplate.postForObject(REST_URL_PROFIX + "/dept/add", dept, Boolean.class);
    }

    @ RequestMapping(value = "/consumer/dept/get/{no}")
    public Dept get(@ PathVariable("no") int no)
    {
        return restTemplate.getForObject(REST_URL_PROFIX + "/dept/get/" + no, Dept.class);
    }

    @ SuppressWarnings("unchecked")
    @ RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list()
    {
        return restTemplate.getForObject(REST_URL_PROFIX + "/dept/list", List.class);
    }

}
