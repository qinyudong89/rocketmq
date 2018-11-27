package com.qinyudong.rocketmq.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.starter.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yu dong qin
 * @ClassName:
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @PostMapping("/test")
    public void test(String json) {
        // Send string
        String topic = "";
        User u = new User();
        u.setName("张三");
        u.setAge(25);
        rocketMQTemplate.send(topic + ":tag1", MessageBuilder.withPayload(u).build());
//        rocketMQTemplate.convertAndSend(topic + ":tag1", u);

    }
}

class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}