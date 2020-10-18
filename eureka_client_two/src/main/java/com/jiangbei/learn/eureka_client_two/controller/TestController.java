package com.jiangbei.learn.eureka_client_two.controller;

import learnEntity.TestEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name",defaultValue = "World")String name){
        return String.format("Hello %s!",name);
    }
    @RequestMapping("/hello2")
    public TestEntity hello2(@RequestParam(value = "name",defaultValue = "World")String name, TestEntity obj){
        TestEntity testEntity = new TestEntity();
        testEntity.setName("fanhui"+obj.getName());
        int i = Integer.parseInt(obj.getAgd());
        String s = String.valueOf(i + 1);
        testEntity.setAgd(s);
        return testEntity;
    }
    @RequestMapping("/hello3")
    public TestEntity hello3(@RequestBody TestEntity testEntity){
        System.out.println(testEntity);
       if(null==testEntity){
           return null;
       }else {
           return testEntity;
       }
    }
}
