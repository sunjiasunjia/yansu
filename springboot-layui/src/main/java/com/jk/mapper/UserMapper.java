package com.jk.mapper;

import com.jk.model.User;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {
    List<User> queryList(User user);

    int queryListOrderCount(HashMap<String, Object> hashMap);

    List<User> queryListOrder(HashMap<String, Object> hashMap);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
