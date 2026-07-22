package com.example.controller;

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
    public Result getStudent(StudentQueryParam studentQueryParam){
     PageResult<Student> studentPageResult = studentService.page(studentQueryParam);
     return Result.success(studentPageResult);
    }
    @DeleteMapping("/{ids}")
    public Result deleteStudent(@PathVariable Integer[] ids){
        studentService.deleteById(ids);
       return  Result.success();
    }
    @PostMapping
    public Result insertStudent (@RequestBody Student student){
        studentService.insert(student);
        return  Result.success();
    }
    @GetMapping("/{id}")
    public Result getStudentById(@PathVariable Integer id){
        Student L = studentService.getStudentById(id);
        return  Result.success(L);
    }
    @PutMapping
    public Result updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return Result.success();
    }
    @PutMapping("/violation/{id}/{score}")
    public Result updateStudentViolation(@PathVariable Integer id, @PathVariable short score){
         studentService.updateStudentViolation(id,score);
        return  Result.success();
    }
}
