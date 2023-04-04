package com.fengrui.service.impl;

import com.fengrui.dao.ExamStudentMediaDao;
import com.fengrui.pojo.ExamStudentMedia;
import com.fengrui.service.ExamStudentMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamStudentMediaServiceImpl implements ExamStudentMediaService {
    @Autowired
    ExamStudentMediaDao examStudentMediaDao;
    @Override
    public Integer addExamStudent(ExamStudentMedia examStudentMedia) {
        return examStudentMediaDao.addExamStudent(examStudentMedia);
    }

    @Override
    public List<ExamStudentMedia> findByUserId(Integer userId) {
        return examStudentMediaDao.findByUserId(userId);
    }

    @Override
    public ExamStudentMedia findByTwoId(Integer examId, Integer userId) {
        return examStudentMediaDao.findByTwoId(examId, userId);
    }

    @Override
    public List<ExamStudentMedia> findALl() {
        return examStudentMediaDao.findAll();
    }

    @Override
    public List<ExamStudentMedia> findByClassId(Integer classId) {
        return examStudentMediaDao.findByClassId(classId);
    }
}
