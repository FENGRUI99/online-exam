package com.fengrui.service.impl;

import com.fengrui.dao.TeaUserDao;
import com.fengrui.pojo.TeaUser;
import com.fengrui.service.TeaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeaUserServiceImpl implements TeaUserService {
    @Autowired
    private TeaUserDao teaUserDao;
    @Override
    public TeaUser login(String username, String password) {
        return teaUserDao.login(username, password);
    }

    @Override
    public String getRealName(String username) {
        return teaUserDao.getRealName(username);
    }
}
