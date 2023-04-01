package com.fengrui.service;

import com.fengrui.pojo.Course;

import java.util.List;

public interface CourseService {
    Course getById(Integer id);
    List<Course> getAllCourse();
}
