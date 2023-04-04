package com.fengrui.service;

import com.fengrui.pojo.ExamStudentMedia;

import java.util.List;

public interface ExamStudentMediaService {
    public Integer addExamStudent(ExamStudentMedia examStudentMedia );
    public List<ExamStudentMedia> findByUserId(Integer userId);
    public ExamStudentMedia findByTwoId(Integer examId, Integer userId);
    public List<ExamStudentMedia> findALl();
    public List<ExamStudentMedia> findByClassId(Integer classId);
}
