package com.fengrui.dao;

import com.fengrui.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseDao {
    Course getById(Integer id);
    List<Course> getAllCourse();
}
