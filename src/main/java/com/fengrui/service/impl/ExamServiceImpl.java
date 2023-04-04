package com.fengrui.service.impl;

import com.fengrui.dao.CourseDao;
import com.fengrui.dao.ExamDao;
import com.fengrui.pojo.Course;
import com.fengrui.pojo.Exam;
import com.fengrui.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    ExamDao examDao;
    @Autowired
    CourseDao courseDao;
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

    @Override
    public List<Exam> getByClassId(Integer classId) {
        List<Course> courses = courseDao.getAllCourse();
        List<Exam> exams = examDao.getByClassId(classId);
        for (int i = 0; i < exams.size(); i++){
            for (int j = 0; j < courses.size(); j++){
                if (exams.get(i).getCourseId().equals(courses.get(j).getId())){
                    exams.get(i).setCourse(courses.get(j));
                }
            }
        }
        return exams;
    }

}
