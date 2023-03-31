package com.fengrui.service.impl;

import com.fengrui.dao.UserDao;
import com.fengrui.pojo.User;
import com.fengrui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User login(String username, String password) {
        User login = userDao.login(username, password);
        return login;
    }

    @Override
    public Integer register(User user) {
        return userDao.register(user);
    }

    @Override
    public List<User> getByName(String name) {
        return userDao.getByName(name);
    }
}
