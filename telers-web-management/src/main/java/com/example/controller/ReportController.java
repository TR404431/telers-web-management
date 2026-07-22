package com.example.controller;

import com.example.pojo.DegreeStat;
import com.example.pojo.JobOption;
import com.example.pojo.Result;
import com.example.pojo.StudentOption;
import com.example.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        List<Map<String, Object>> ll = reportService.getEmpGenderData();
        return Result.success(ll);
    }

    @GetMapping("/studentCountData")
    public Result getStudentCountData() {
        log.info("统计班级人数");
        StudentOption studentOption = reportService.getStudentCountData();
        return Result.success(studentOption);
    }

    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData() {
        List<DegreeStat> i = reportService.getValueAndName();
        return Result.success(i);
    }
}
