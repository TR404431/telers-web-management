package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.mapper.StudentMapper;
import com.example.pojo.DegreeStat;
import com.example.pojo.JobOption;
import com.example.pojo.Student;
import com.example.pojo.StudentOption;
import com.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper  empMapper;
    @Autowired
    private StudentMapper studentMapper;
    /*
  统计员工职位人数
   */
    @Override
    public JobOption getEmpJobData() {
       //1.调用Mapper接口,获取统计数据
        List<Map<String,Object>> list = empMapper.countEmpJobData();
       //2.组装结果，并返回
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();
        return  new JobOption(jobList,dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {

        return empMapper.countGenderData();
    }

    @Override
    public List<DegreeStat> getValueAndName() {
        List<DegreeStat> studentList = studentMapper.getValveAndName();
        return studentList;
    }

    @Override
    public StudentOption getStudentCountData() {
        List<Map<String,Object>> list = studentMapper.getStudentCountData();
        List<Object> clazzList = list.stream().map(dataMap -> dataMap.get("clazzName")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("count")).toList();
        return new StudentOption(clazzList, dataList);
    }
}
