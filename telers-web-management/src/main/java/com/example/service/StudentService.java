package com.example.service;

import com.example.pojo.*;

import java.util.List;
import java.util.Map;

public interface StudentService {
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    void deleteById(Integer[] ids);

    void insert(Student student);

    Student getStudentById(Integer id);

    void updateStudent(Student student);

    void updateStudentViolation(Integer id, short score);


}
