package com.fengrui.service;

import com.fengrui.pojo.ExamQuestionMedia;

import java.util.List;

public interface ExamQuestionMediaService {
    Integer addExamQuestion(Integer examId, Integer courseId, Integer questionNumber);
    Integer deleteById(Integer examId);
    Integer updateExamQuestion(Integer examId, Integer courseId, Integer questionNumber);
    List<ExamQuestionMedia> getByExamId(Integer examId);
}
