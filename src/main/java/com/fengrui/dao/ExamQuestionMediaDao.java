package com.fengrui.dao;

import com.fengrui.pojo.ExamQuestionMedia;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamQuestionMediaDao {
    Integer addExamQuestion(ExamQuestionMedia examQuestionMedia);
    Integer deleteById(Integer examId);
    List<ExamQuestionMedia> getByExamId(Integer examId);
}
