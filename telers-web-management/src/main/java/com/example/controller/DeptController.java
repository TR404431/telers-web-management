package com.example.controller;
import com.example.annotation.LogOperation;
import com.example.pojo.Dept;
import com.example.pojo.Emp;
import com.example.pojo.Result;
import com.example.service.DeptService;
import com.example.service.EmpService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private EmpService empService;
    @Autowired
    private DeptService deptService;
    @GetMapping
    @LogOperation
    public Result list(){
        log.info("查询部门列表");
    List<Dept>  deptList = deptService.findAll();
    return  Result.success(deptList);
    }
    @DeleteMapping
    //第一种方式 通过原始的HttpServletRequest对象来获取请求参数
//    public Result delete(HttpServletRequest request){
//        String idstr =  request.getParameter("id");
//        int id = Integer.parseInt(idstr);
//        return Result.success();
//    }
    //第二种方式 通过Spring提供的@RequestParam注解
//    public Result delete(@RequestParam("id") Integer id){
//        return Result.success();
//    }
//    第三种方式省略@RequestParam注解(前端传递的请求参数名与服务段方法形参名一致)
    @LogOperation
    public Result delete(Integer id){
        log.info("根据id删除部门:{}",id);
        deptService.deleteById(id);
        return Result.success();
    }
    @PostMapping
    @LogOperation
    public Result add(@RequestBody Dept dept){
        log.info("新增部门,dept:{}",dept);
        deptService.add(dept);
        return Result.success();
    }
    @GetMapping("/{id}")
    @LogOperation
    public Result get(@PathVariable("id") Integer id){
        log.info("根据ID查询, id: {}" , id);
        Dept dept  = deptService.getById(id);
        return Result.success(dept);
    }
    @PutMapping
    @LogOperation
    public Result update(@RequestBody Dept dept){
        log.info("修改部门, dept: {}" , dept);
        deptService.update(dept);
        return Result.success();
    }

}
