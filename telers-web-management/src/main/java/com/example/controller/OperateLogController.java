package com.example.controller;

import com.example.pojo.LogQueryParam;
import com.example.pojo.OperateLog;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class OperateLogController {

    @Autowired
    private OperateLogService operateLogService;

    @GetMapping("/page")
    public Result page(LogQueryParam logQueryParam) {
        PageResult<OperateLog> pageResult = operateLogService.page(logQueryParam);
        return Result.success(pageResult);
    }
}
