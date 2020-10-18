package com.jiangbei.learn.customer_client_one.controller;

import learnEntity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/hello")
    public String  Hello(@RequestParam(value = "name",defaultValue = "Rest")String name){
        return restTemplate.getForObject("http://CLIENT2/hello?name="+name, String.class);
    }
    @RequestMapping("/hello1")
    public String hello1(@RequestParam(value = "name",defaultValue = "Rest1")String name){
        ServiceInstance client2 = loadBalancerClient.choose("CLIENT2");
        String s = restTemplate.getForObject("http://" + client2.getHost() + ":" + client2.getPort() + "/hello?name=" + name, String.class);
        return s;
    }
    @RequestMapping("/hello2")
    public TestEntity Hello2(@RequestParam(value = "name",defaultValue = "Rest")String name){
        TestEntity testEntity = new TestEntity();
        testEntity.setName("haha");
        testEntity.setAgd("18");
        ResponseEntity<TestEntity> name1 = restTemplate.getForEntity("http://CLIENT2/hello2?obj={obj}", TestEntity.class,testEntity);
        TestEntity body = name1.getBody();
        System.out.println(body);
        return body;
    }
    @RequestMapping("/hello3")
    public TestEntity Hello3(@RequestParam(value = "name",defaultValue = "Rest")String name){
        TestEntity testEntity = new TestEntity();
        testEntity.setName("haha");
        testEntity.setAgd("18");
        TestEntity name1 = restTemplate.postForObject("http://CLIENT2/hello3",testEntity,TestEntity.class);

        return name1;
    }
}
