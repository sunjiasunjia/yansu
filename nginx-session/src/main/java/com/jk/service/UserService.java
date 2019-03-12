package com.jk.service;

import com.jk.model.User;
import org.springframework.cache.annotation.Cacheable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {


    String loginByName(String name, String pass, HttpServletRequest request);

    User getUserInfo(HttpServletRequest request);

    List<User> queryUserList();

    void delsUser(Integer id);

    void addUser(User user);

    User userModel(Integer id);

    void updateUser(User user);
}
