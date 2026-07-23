package com.example.controller;

import com.example.annotation.LogOperation;
import com.example.pojo.*;
import com.example.service.ClazzService;
import com.example.service.EmpService;
import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clazzs")
public class ClassController {
    @Autowired
    ClazzService clazzService ;
    @Autowired
    EmpService empService ;
    @GetMapping
    @LogOperation
    public Result getDepts(ClassQueryParam classQueryParam) {
        PageResult<Clazz> pageResult = clazzService.page(classQueryParam);
        return Result.success(pageResult);
    }
    @DeleteMapping("/{id}")
    @LogOperation
    public Result delete(@PathVariable String id) {
        clazzService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    @LogOperation
    public Result save(@RequestBody Clazz clazz) {
        clazzService.save(clazz);
        return Result.success();
    }
    @GetMapping("/{id}")
    @LogOperation
    public Result getById(@PathVariable String id) {
        return Result.success(clazzService.getById(id));
    }
    @PutMapping
    @LogOperation
    public Result update(@RequestBody Clazz clazz) {
        clazzService.update(clazz);
        return Result.success();
    }
    @GetMapping("/list")
    @LogOperation
    public Result list() {
        List<Clazz> l = clazzService.seleteAll();
        return  Result.success(l);
    }

}
