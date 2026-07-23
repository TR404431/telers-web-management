package com.example.service.impl;

import com.example.mapper.OperateLogMapper;
import com.example.pojo.LogQueryParam;
import com.example.pojo.OperateLog;
import com.example.pojo.PageResult;
import com.example.service.OperateLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public PageResult<OperateLog> page(LogQueryParam logQueryParam) {
        PageHelper.startPage(logQueryParam.getPage(), logQueryParam.getPageSize());
        List<OperateLog> list = operateLogMapper.page();
        Page<OperateLog> page = (Page<OperateLog>) list;
        return new PageResult<>(page.getTotal(), page.getResult());
    }
}
