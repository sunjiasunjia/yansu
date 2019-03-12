package com.jk.controller;

import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("login")
    public String toLogin(){
        return "login";
    }

    /**
     *登录
     * @param name
     * @param pass
     * @param request
     * @return
     */
    @RequestMapping("loginByName")
    @ResponseBody
    public String loginByName(@RequestParam(value = "name") String name, @RequestParam(value = "pass") String pass, HttpServletRequest request){
        String result = userService.loginByName(name,pass,request);
        return result;
    }

    @RequestMapping("getUserInfo")
    @ResponseBody
    public Map<String, Object> getUserInfo(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        User user = userService.getUserInfo(request);
        map.put("user",user);
        return map;
    }

}
