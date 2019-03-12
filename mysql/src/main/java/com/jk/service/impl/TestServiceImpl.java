/**
 * Copyright (C),2018
 * FileName: 段国强
 * Author:   admin
 * Date:     2019/1/16 17:21
 * Description:
 * History:
 */
package com.jk.service.impl;

import com.jk.mapper.TestMapper;
import com.jk.model.TestBean;
import com.jk.service.TestService;
import com.jk.utils.ReadOnlyConnection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author admin
 * @create 2019/1/16
 * @since 1.0.0
 */
@Service
public class TestServiceImpl implements TestService {


    @Resource
    private TestMapper testMapper;


    @Override
    @ReadOnlyConnection
    public List<TestBean> query() {

        return testMapper.query();
    }

    @Override
    public void add(TestBean testBean) {
        testMapper.add(testBean);
    }
}
