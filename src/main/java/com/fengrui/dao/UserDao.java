package com.fengrui.dao;

import com.fengrui.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    User login(String username, String password);
    Integer register(User user);
    List<User> getByName(String name);
}
