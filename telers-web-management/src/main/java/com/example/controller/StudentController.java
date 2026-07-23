package com.example.controller;

import com.example.annotation.LogOperation;
import com.example.pojo.*;
import com.example.service.StudentService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    @LogOperation
    public Result getStudent(StudentQueryParam studentQueryParam){
     PageResult<Student> studentPageResult = studentService.page(studentQueryParam);
     return Result.success(studentPageResult);
    }
    @DeleteMapping("/{ids}")
    @LogOperation
    public Result deleteStudent(@PathVariable Integer[] ids){
        studentService.deleteById(ids);
       return  Result.success();
    }
    @PostMapping
    @LogOperation
    public Result insertStudent (@RequestBody Student student){
        studentService.insert(student);
        return  Result.success();
    }
    @GetMapping("/{id}")
    @LogOperation
    public Result getStudentById(@PathVariable Integer id){
        Student L = studentService.getStudentById(id);
        return  Result.success(L);
    }
    @PutMapping
    @LogOperation
    public Result updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return Result.success();
    }
    @PutMapping("/violation/{id}/{score}")
    @LogOperation
    public Result updateStudentViolation(@PathVariable Integer id, @PathVariable short score){
         studentService.updateStudentViolation(id,score);
        return  Result.success();
    }
}
