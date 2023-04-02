package com.fengrui.service;

import com.fengrui.pojo.ExamQuestionMedia;

public interface ExamQuestionMediaService {
    Integer addExamQuestion(Integer examId, Integer courseId, Integer questionNumber);
}
