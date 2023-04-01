package com.fengrui.dao;

import com.fengrui.pojo.Class;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassDao {
    List<Class> getAll();

    Class getClassById(Integer id);
}
