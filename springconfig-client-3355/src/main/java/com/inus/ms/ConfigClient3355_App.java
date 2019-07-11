
package com.inus.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@ SpringBootApplication
@ EnableEurekaClient
public class ConfigClient3355_App
{

    public static void main(String[] args)
    {
        SpringApplication.run(ConfigClient3355_App.class, args);
    }

}
