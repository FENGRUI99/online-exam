package com.fengrui.service.impl;

import com.fengrui.dao.ClassDao;
import com.fengrui.pojo.Class;
import com.fengrui.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassDao classDao;

    @Override
    public List<Class> getAll() {
        return classDao.getAll();
    }

    @Override
    public Class getClassById(Integer id) {
        return classDao.getClassById(id);
    }
}
