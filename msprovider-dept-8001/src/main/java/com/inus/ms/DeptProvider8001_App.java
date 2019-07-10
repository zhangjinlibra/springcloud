
package com.inus.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@ SpringBootApplication
@ EnableEurekaClient
@ EnableHystrix
public class DeptProvider8001_App
{

    public static void main(String[] args)
    {
        SpringApplication.run(DeptProvider8001_App.class, args);
    }

}
