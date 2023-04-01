package com.fengrui.dao;

import com.fengrui.pojo.TeaUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeaUserDao {
    TeaUser login(String username, String password);
    String getRealName(String username);
}
