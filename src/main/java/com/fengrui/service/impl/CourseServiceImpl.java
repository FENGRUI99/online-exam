package com.fengrui.service.impl;

import com.fengrui.dao.CourseDao;
import com.fengrui.pojo.Course;
import com.fengrui.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public Course getById(Integer id) {
        return courseDao.getById(id);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }
}
