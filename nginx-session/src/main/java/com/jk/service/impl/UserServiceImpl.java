package com.jk.service.impl;

import com.jk.mapper.UserMapper;
import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    /**
     * 登录
     * @param name
     * @param pass
     * @param request
     * @return
     */
    @Override
    public String loginByName(String name, String pass, HttpServletRequest request) {
        User user = mapper.userLogin(name);
        if(user != null){
            if(user.getPass().equals(pass)){
                HttpSession session = request.getSession();
                session.setAttribute(session.getId(),user);
                return "0"; //登录成功
            }else{
                return "2"; //用户名不存在
            }
        }else{
            return "1"; //账号错误
        }
    }

    /**
     * 获取当前登录信息
     * @param request
     * @return
     */
    @Override
    @Cacheable(value="common", key="#root.methodName")
    public User getUserInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(session.getId());
        return user;
    }

    @Override
    public List<User> queryUserList() {
        return mapper.queryUserList();
    }

    @Override
    public void delsUser(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addUser(User user) {
        mapper.insertSelective(user);
    }

    @Override
    public User userModel(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateUser(User user) {
        mapper.updateByPrimaryKeySelective(user);
    }

}
