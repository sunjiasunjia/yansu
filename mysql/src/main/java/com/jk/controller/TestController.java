/**
 * Copyright (C),2018
 * FileName: 段国强
 * Author:   admin
 * Date:     2019/1/16 17:18
 * Description:
 * History:
 */
package com.jk.controller;

import com.jk.model.TestBean;
import com.jk.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author admin
 * @create 2019/1/16
 * @since 1.0.0
 */
@Controller
public class TestController {


    @Autowired
    private TestService testService;


    // 查询测试
    @RequestMapping("query")
    @ResponseBody
    public List<TestBean> query(){

       return testService.query();
    }

    // 新增测试
    @RequestMapping("add")
    public void add(){
        TestBean testBean = new TestBean();
        testBean.setName("测试新增");
        testBean.setPassword("123");
        testService.add(testBean);
    }



}
