package com.fengrui.service;

import com.fengrui.pojo.Exam;

import java.util.List;

public interface ExamService {
    public Integer addExam(Exam exam);
    public Exam getById(Integer id);
    public List<Exam> getAll();
    public Integer deleteExam(Integer id);
    public Integer updateExam(Exam exam);
    public List<Exam> getByClassId(Integer classId);
}
