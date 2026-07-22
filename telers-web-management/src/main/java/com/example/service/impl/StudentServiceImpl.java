package com.example.service.impl;

import com.example.mapper.StudentMapper;
import com.example.pojo.*;
import com.example.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl  implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());
        List<Student> L = studentMapper.list(studentQueryParam.getName(),studentQueryParam.getDegree(),studentQueryParam.getClazzId());
        Page<Student> page = (Page<Student>) L;
        return new PageResult<>(page.getTotal(),page.getResult());
    }

    @Override
    public void deleteById(Integer[] ids) {
        studentMapper.deleteById(ids);
    }

    @Override
    public void insert(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public Student getStudentById(Integer id) {

        return studentMapper.getStudentById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public void updateStudentViolation(Integer id, short score) {
        studentMapper.updateStudentViolation(id,score);
    }

}
