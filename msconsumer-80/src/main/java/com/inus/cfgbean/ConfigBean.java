
package com.inus.cfgbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.rule.FooRule;

@ Configuration
public class ConfigBean
{

    @ Bean
    @ LoadBalanced // 辅助均衡, 没有就使用默认的
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

    // @ Bean
    public IRule getRule()
    {
        return new FooRule();
    }

}
