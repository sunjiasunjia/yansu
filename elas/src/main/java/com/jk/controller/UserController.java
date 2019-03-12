package com.jk.controller;

import com.jk.model.User;
import com.jk.service.UserService;
import com.jk.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: es
 * @description:
 * @author: 孙佳
 * @create: 2019-01-17 11:26
 **/
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    /*
     * 分页
     */
    @RequestMapping("userEs")
    @ResponseBody
    public PageResult queryListUser(User user, Integer page, Integer rows){
        PageResult queryListUser = userService.queryListUser(user,page,rows);
        return queryListUser;
    }
    @RequestMapping("toUser")
    public String toUser(){
        return "user";
    }
}
