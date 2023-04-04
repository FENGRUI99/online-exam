package com.fengrui.dao;

import com.fengrui.pojo.ExamStudentMedia;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamStudentMediaDao {
    Integer addExamStudent(ExamStudentMedia examStudentMedia);
    List<ExamStudentMedia> findByUserId(Integer userId);
    ExamStudentMedia findByTwoId(Integer examId, Integer userId);
    List<ExamStudentMedia> findAll();
    List<ExamStudentMedia> findByClassId(Integer classId);
}
