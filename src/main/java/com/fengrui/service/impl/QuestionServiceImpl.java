package com.fengrui.service.impl;

import com.fengrui.dao.QuestionDao;
import com.fengrui.pojo.Question;
import com.fengrui.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;

    @Override
    public Integer addQuestion(Question question) {
        return questionDao.addQuestion(question);
    }

    @Override
    public List<Question> findAll() {
        return questionDao.findAll();
    }

    @Override
    public Question findById(Integer id) {
        return questionDao.findById(id);
    }

    @Override
    public Integer updateQuestion(Question question) {
        return questionDao.updateQuestion(question);
    }

    @Override
    public Integer deleteQuestion(Integer id) {
        return questionDao.deleteQuestion(id);
    }
}
