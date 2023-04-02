package com.fengrui.dao;

import com.fengrui.pojo.ExamQuestionMedia;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExamQuestionMediaDao {
    Integer addExamQuestion(ExamQuestionMedia examQuestionMedia);

}
