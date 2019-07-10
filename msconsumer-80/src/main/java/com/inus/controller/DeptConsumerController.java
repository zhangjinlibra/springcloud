
package com.inus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.inus.ms.entities.Dept;

@ RestController
public class DeptConsumerController
{

    @ Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PROFIX = "http://MSPROVIDER";

    @ ResponseBody
    @ RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept)
    {
        Object o = restTemplate.postForObject(REST_URL_PROFIX + "/dept/add", dept, Object.class);
        System.out.println(o);
        return true;
    }

    @ ResponseBody
    @ RequestMapping(value = "/consumer/dept/get/{no}")
    public Dept get(@ PathVariable("no") int no)
    {
        return restTemplate.getForObject(REST_URL_PROFIX + "/dept/get/" + no, Dept.class);
    }

    @ ResponseBody
    @ RequestMapping(value = "/consumer/dept/list"/* , produces = {"application/json;charset=UTF-8"} */)
    public List<Dept> list()
    {
        @ SuppressWarnings("unchecked")
        List<Dept> list = restTemplate.getForObject(REST_URL_PROFIX + "/dept/list", List.class);
        if (list != null && list.size() > 0)
        {
            for (Object o : list)
            {
                System.out.println(o);
            }
        }
        return list;
    }

}
