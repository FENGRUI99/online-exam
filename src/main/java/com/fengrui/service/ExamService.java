package com.fengrui.service;

import com.fengrui.pojo.Exam;

public interface ExamService {
    public Integer addExam(Exam exam);
    public Exam getById(Integer id);
}
