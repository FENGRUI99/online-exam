package com.fengrui.dao;

import com.fengrui.pojo.Exam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExamDao {
    Integer addExam(Exam exam);
    Exam getById(Integer id);
}
