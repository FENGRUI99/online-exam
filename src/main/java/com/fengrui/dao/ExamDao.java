package com.fengrui.dao;

import com.fengrui.pojo.Exam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamDao {
    Integer addExam(Exam exam);
    Exam getById(Integer id);
    List<Exam> getAll();
    Integer deleteExam(Integer id);
    Integer updateExam(Exam exam);
    List<Exam> getByClassId(Integer classId);
}
