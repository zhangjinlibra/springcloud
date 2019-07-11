
package com.rule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@ Configuration
public class FooLoadBalancer
{

    @ Bean
    public IRule getFooRule()
    {
        return new FooRule();
    }

}
