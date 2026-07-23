package com.example.controller;

import com.example.annotation.LogOperation;
import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize,
//                       String name, Integer gender,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin ,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
//      log.info("分页查询:{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
    //      PageResult<Emp> pageResult = empService.page(page,pageSize,name,gender,begin,end);
    //      return Result.success(pageResult);
    //    }
    @GetMapping
    @LogOperation
    public Result page(EmpQueryParam empQueryParam){
        log.info("分页查询:{}",empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }
    @PostMapping
    @LogOperation
    public Result save(@RequestBody Emp emp){
        empService.save(emp);
        return Result.success();
    }

    /**
     *
     * 删除员工
     * @return
     */
    @DeleteMapping
    @LogOperation
    public Result delete(@RequestParam List<Integer> ids){
        empService.delete(ids);
        return Result.success();
    }
    /**
     * 根据id查询员工信息
     */
    @GetMapping("/{id}")
    @LogOperation
    public Result getInfo(@PathVariable Integer id){
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }
    @PutMapping
    @LogOperation
    public Result update(@RequestBody Emp emp){
        empService.update(emp);
        return Result.success();
    }
    @GetMapping("/list")
    @LogOperation
    public Result list(){
        List<Emp> list = empService.selectAll();
        return Result.success(list);
    }
}
