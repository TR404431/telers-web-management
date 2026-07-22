package com.example.controller;

import com.example.pojo.Result;
import com.example.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    /**
     *
     * 本地磁盘存储方案
    *@PostMapping("/upload")
    public Result upload (String name,Integer id,MultipartFile file) throws IOException {
        //获取原始文件名
        String t = file.getOriginalFilename();
        //新的文件名
          String e = t.substring(t.lastIndexOf("."));
          String t1 = UUID.randomUUID().toString() + e;
        //保存文件
        file.transferTo(new File("E:/images/" + t1));
        return Result.success();
    }*/
    @Autowired
    private AliyunOSSOperator  aliyunOSSOperator;
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        //将文件交给oss存储管理
       String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
       return Result.success(url);
    }
}