/**
 * Copyright (C),2018
 * FileName: 段国强
 * Author:   admin
 * Date:     2019/1/16 17:20
 * Description:
 * History:
 */
package com.jk.service;

import com.jk.model.TestBean;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author admin
 * @create 2019/1/16
 * @since 1.0.0
 */
public interface TestService {


    List<TestBean> query();

    void add(TestBean testBean);
}
