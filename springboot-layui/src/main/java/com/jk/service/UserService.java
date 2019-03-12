package com.jk.service;

import com.jk.model.User;
import com.jk.util.LayuiPage;

import java.util.List;

public interface UserService
{
    List<User> queryList(User user);

    LayuiPage queryListUser(User user, Integer page, Integer limit);

    void deleteUser(Integer id);

    void updateUser(User user);

    void addUser(User user);
}
