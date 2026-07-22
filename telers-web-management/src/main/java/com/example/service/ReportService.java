package com.example.service;

import com.example.pojo.DegreeStat;
import com.example.pojo.JobOption;
import com.example.pojo.Student;
import com.example.pojo.StudentOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();

    List<DegreeStat> getValueAndName();

    StudentOption getStudentCountData();
}
