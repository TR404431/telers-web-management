package com.example.service.impl;

import com.example.mapper.ClazzMapper;
import com.example.pojo.ClassQueryParam;
import com.example.pojo.Clazz;
import com.example.pojo.PageResult;
import com.example.service.ClazzService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    @Transactional
    public PageResult<Clazz> page(ClassQueryParam classQueryParam) {
        //1设置分页参数（PageHelper)
        PageHelper.startPage(classQueryParam.getPage(),classQueryParam.getPageSize());
        //2执行查询
        List<Clazz> clazzList = clazzMapper.clazzList(classQueryParam.getName(),classQueryParam.getBegin(),classQueryParam.getEnd());
        //3解析查询结果，并封装
        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult<Clazz>(p.getTotal(),p.getResult());
    }
    @Transactional
    @Override
    public void deleteById(String id) {
        clazzMapper.deletrById(id);
    }

    @Override
    public void save(Clazz clazz) {
       clazzMapper.save(clazz);
    }

    @Override
    public Clazz getById(String id) {
        return clazzMapper.getById(id);
    }
   @Transactional
    @Override
    public void update(Clazz clazz) {
        clazzMapper.update(clazz);
    }

    @Override
    public List<Clazz> seleteAll() {

        return clazzMapper.seleteAll();
    }
}
