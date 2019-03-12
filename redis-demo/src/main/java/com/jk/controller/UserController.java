package com.jk.controller;

import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("adduser")
    @ResponseBody
    public Object adduser() {
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setName("龙龙");
        redisTemplate.opsForValue().set("user1", user);
        System.out.println("新增成功");
        return user;
    }

    @RequestMapping("queryUser")
    @ResponseBody
    public User queryUser() {
        User user1 = (User) redisTemplate.opsForValue().get("user1");
        System.out.println("查询成功");
        return user1;
    }


}
