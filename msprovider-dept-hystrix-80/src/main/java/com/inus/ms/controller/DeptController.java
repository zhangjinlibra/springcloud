
package com.inus.ms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inus.ms.entities.Dept;
import com.inus.ms.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@ RestController
public class DeptController
{

    @ Autowired
    private DeptService deptService;

    @ RequestMapping("/dept/add")
    public boolean add(HttpServletRequest request, @ RequestBody Dept dept) throws IOException
    {
        return deptService.add(dept);
    }

    @ RequestMapping("/dept/get/{no}")
    @ HystrixCommand(fallbackMethod = "getFallBackForHystrix")
    public Dept get(@ PathVariable("no") Integer no)
    {
        Dept dept = deptService.get(no);
        if (dept == null)
        {
            throw new RuntimeException("该ID: @ID@没有对应的信息".replace("@ID@", String.valueOf(no)));
        }
        return dept;
    }

    public Dept getFallBackForHystrix(@ PathVariable("no") Integer no)
    {
        return new Dept()//
            .setNo(no).setName("该ID: @ID@没有对应的信息, hystrix command".replace("@ID@", String.valueOf(no)))//
            .setDb("no this data in database");
    }

    @ RequestMapping("/dept/list")
    public List<Dept> list()
    {
        return deptService.list();
    }

    @ Autowired
    private DiscoveryClient client;

    @ RequestMapping("/discobery/services")
    private void discovery()
    {
        List<String> services = client.getServices();
        if (services != null && services.size() > 0)
        {
            for (String service : services)
            {
                List<ServiceInstance> instances = client.getInstances(service);
                if (instances != null && instances.size() > 0)
                {
                    for (ServiceInstance instance : instances)
                    {
                        System.out.println(instance.getHost() + "\t"//
                            + instance.getPort() + "\t"//
                            + instance.getServiceId() + "\t"//
                            + instance.getUri() + "\t"//
                        );
                    }
                }
            }
        }
    }

}
