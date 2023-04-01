package com.fengrui.dao;
import com.fengrui.pojo.Question;
import org.apache.ibatis.annotations.Mapper;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import java.util.List;

@Mapper
public interface QuestionDao {
    List<Question> findAll();
    Integer addQuestion(Question question);
    Question findById(Integer id);
    Integer updateQuestion(Question question);
    Integer deleteQuestion(Integer id);

}
