
package com.inus.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@ EnableEurekaClient
@ SpringBootApplication
@ EnableHystrix
@ EnableHystrixDashboard
public class HystrixDashboard9001_App
{

    public static void main(String[] args)
    {
        SpringApplication.run(HystrixDashboard9001_App.class, args);
    }

}
