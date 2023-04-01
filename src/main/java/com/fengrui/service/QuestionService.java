package com.fengrui.service;

import com.fengrui.pojo.Question;

import java.util.List;

public interface QuestionService {
     List<Question> findAll();
     Integer addQuestion(Question question);
     Question findById(Integer id);
     Integer updateQuestion(Question question);
     Integer deleteQuestion(Integer id);
}
