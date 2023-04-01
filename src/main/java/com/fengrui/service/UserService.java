package com.fengrui.service;

import com.fengrui.pojo.User;

import java.util.List;

public interface UserService {
    User login(String username, String password);
    Integer register(User user);
    List<User> getByName(String name);
    List<User> pageByClassId(Integer classId);
    User getById(Integer id);
    Integer update(User user);
    Integer delete(Integer id);
    Integer deleteAll(Integer classId);
}
