/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserController
 * Author:   Administrator
 * Date:     2019-1-24 10:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 王鹏程         修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.model.User;
import com.jk.service.UserService;
import com.jk.util.LayuiPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019-1-24
 * @since 1.0.0
 */
@Controller
public class UserController {

    @Autowired
    private UserService UserService;


    @RequestMapping("index")
    public String index(){
        return "index";
    }

    /*
     * 普通查询
     */
    @RequestMapping("queryList")
    @ResponseBody
    public LayuiPage queryList(User user){
        LayuiPage layuiPage = new LayuiPage();
        List<User> queryList=  UserService.queryList(user);
        layuiPage.setCode(0);
        layuiPage.setMsg("");
        layuiPage.setCount(5);
        layuiPage.setData(queryList);
        return layuiPage;
    }
    /*
     * 分页查询
     */
    @RequestMapping("queryListUser")
    @ResponseBody
    public LayuiPage queryListUser(User user,Integer page,Integer limit){
        LayuiPage layuiPage = new LayuiPage();
        LayuiPage queryList=  UserService.queryListUser(user,page,limit);
        return queryList;
    }

    /*
     * 删除
     */
    @RequestMapping("deleteUser")
    @ResponseBody
    public String deleteUser(Integer id){
        try {
            UserService.deleteUser(id);
            return "1";
        }catch (Exception e){
            e.printStackTrace();
            return "0";
        }
    }

    /*
     * 新增
     */
    @RequestMapping("addUser")
    @ResponseBody
    public String addUser(User user){
        if(user.getId() != null ){
            try {
                UserService.updateUser(user);
                return "1";
            }catch (Exception e){
                e.printStackTrace();
                return "0";
            }
        }else {
            try {
                UserService.addUser(user);
                return "1";
            }catch (Exception e){
                e.printStackTrace();
                return "0";
            }
        }
    }

}

