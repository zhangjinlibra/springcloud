
package com.inus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.rule.FooLoadBalancer;

@ SpringBootApplication
@ EnableEurekaClient // 开启erueka客户端服务
@ RibbonClient(name = "MSPROVIDER", configuration = FooLoadBalancer.class) // 开启Ribbon客户端辅助均衡服务, 不需要自定义则不需要该注解
public class DeptConsumer80_App
{
    public static void main(String[] args)
    {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }

}
