package com.jk.service;

import com.jk.model.User;
import com.jk.util.PageResult;

/**
 * @program: es
 * @description:
 * @author: 孙佳
 * @create: 2019-01-17 11:27
 **/
public interface UserService {
    PageResult queryListUser(User user, Integer page, Integer rows);
}
