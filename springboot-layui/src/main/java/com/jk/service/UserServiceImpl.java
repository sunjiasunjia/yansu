/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserServiceImpl
 * Author:   Administrator
 * Date:     2019-1-24 10:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 王鹏程         修改时间           版本号              描述
 */
package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.User;
import com.jk.util.LayuiPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019-1-24
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    /*
     * 查询
     */
    @Override
    public List<User> queryList(User user) {
        List<User> queryList = userMapper.queryList(user);
        return queryList;
    }

    /*
     * 分页查询
     */
    @Override
    public LayuiPage queryListUser(User user, Integer page, Integer limit) {

        LayuiPage layuiPage = new LayuiPage();
        HashMap<String,Object> hashMap = new HashMap<String, Object>();
        hashMap.put("user", user);
        int total = userMapper.queryListOrderCount(hashMap);
        hashMap.put("startindex", (page-1)*limit);
        hashMap.put("limit", limit);
        List<User> list = userMapper.queryListOrder(hashMap);
        layuiPage.setCode(0);
        layuiPage.setMsg("网络堵塞");
        layuiPage.setCount(total);// 当前存放几条
        layuiPage.setData(list);  ///存放查询出来的数据 list集合
        return layuiPage;
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void addUser(User user) {
        userMapper.insertSelective(user);
    }
}

