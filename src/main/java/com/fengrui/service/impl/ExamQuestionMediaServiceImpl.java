package com.fengrui.service.impl;

import com.fengrui.dao.ExamQuestionMediaDao;
import com.fengrui.dao.QuestionDao;
import com.fengrui.pojo.ExamQuestionMedia;
import com.fengrui.pojo.Question;
import com.fengrui.service.ExamQuestionMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamQuestionMediaServiceImpl implements ExamQuestionMediaService {
    @Autowired
    ExamQuestionMediaDao examQuestionMediaDao;
    @Autowired
    QuestionDao questionDao;
    @Override
    public Integer addExamQuestion(Integer examId, Integer courseId, Integer questionNumber) {
        List<Question> questions = questionDao.findByCourseId(courseId);
        for (int i = 0; i < Math.min(questions.size(), questionNumber); i++){
            ExamQuestionMedia examQuestionMedia = new ExamQuestionMedia();
            Question question = questions.get(i);
            examQuestionMedia.setExamId(examId);
            examQuestionMedia.setCourseId(courseId);
            examQuestionMedia.setQuestionId(question.getId());
            examQuestionMedia.setQuestionContent(question.getQuestionContent());
            examQuestionMedia.setOptionA(question.getOptionA());
            examQuestionMedia.setOptionB(question.getOptionB());
            examQuestionMedia.setOptionC(question.getOptionC());
            examQuestionMedia.setOptionD(question.getOptionD());
            examQuestionMedia.setAnswer(question.getAnswer());
            examQuestionMediaDao.addExamQuestion(examQuestionMedia);
        }
        return Math.min(questions.size(), questionNumber);
    }
}
