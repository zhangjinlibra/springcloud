
package com.inus.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.inus.ms.entities.Dept;

import feign.hystrix.FallbackFactory;

@ Component
public class DeptServiceFallbackFactory implements FallbackFactory<DeptConsumerService>
{

    @ Override
    public DeptConsumerService create(Throwable cause)
    {
        return new DeptConsumerService()
        {

            @ Override
            public List<Dept> list()
            {
                return null;
            }

            @ Override
            public Dept get(int no)
            {
                return new Dept()//
                    .setNo(no).setName("该ID: @ID@没有对应的信息, hystrix command".replace("@ID@", String.valueOf(no)))//
                    .setDb("no this data in database");
            }

            @ Override
            public boolean add(Dept dept)
            {
                return false;
            }
        };
    }

}
