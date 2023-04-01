package com.fengrui.service;

import com.fengrui.pojo.TeaUser;

public interface TeaUserService {
    TeaUser login(String username, String password);
    String getRealName(String username);
}
