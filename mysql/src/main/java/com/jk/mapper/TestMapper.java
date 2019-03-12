/**
 * Copyright (C),2018
 * FileName: 段国强
 * Author:   admin
 * Date:     2019/1/16 17:21
 * Description:
 * History:
 */
package com.jk.mapper;

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
public interface TestMapper {


    List<TestBean> query();

    void add(TestBean testBean);
}
