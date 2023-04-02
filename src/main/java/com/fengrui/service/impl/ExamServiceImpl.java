package com.fengrui.service.impl;

import com.fengrui.dao.ExamDao;
import com.fengrui.pojo.Exam;
import com.fengrui.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    ExamDao examDao;
    @Override
    public Integer addExam(Exam exam) {
        return examDao.addExam(exam);
    }

    @Override
    public Exam getById(Integer id) {
        return examDao.getById(id);
    }

    @Override
    public List<Exam> getAll() {
        return examDao.getAll();
    }

    @Override
    public Integer deleteExam(Integer id) {
        return examDao.deleteExam(id);
    }

    @Override
    public Integer updateExam(Exam exam) {
        return examDao.updateExam(exam);
    }
}
