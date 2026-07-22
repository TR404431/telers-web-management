package com.example.service;

import com.example.pojo.ClassQueryParam;
import com.example.pojo.Clazz;
import com.example.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    PageResult<Clazz> page(ClassQueryParam classQueryParam);

    void deleteById(String id);

    void save(Clazz clazz);

    Clazz getById(String id);

    void update(Clazz clazz);

    List<Clazz> seleteAll();
}
