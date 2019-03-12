package com.jk.controller;

import com.jk.model.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestUserController {

    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping("findUser")
    @ResponseBody
    public int findUser(){
        List<TestUser> list = mongoTemplate.find(new Query(), TestUser.class);
        System.out.println(list);
        return  1;
    }

    @RequestMapping("addUser")
    @ResponseBody
    public int addUser(){
        TestUser testUser = new TestUser();
        testUser.setId(1);
        testUser.setName("222");
        mongoTemplate.save(testUser);
        return 1;
    }
}
