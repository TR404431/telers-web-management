package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentQueryParam {
    private String name;
    private Integer degree;
    private  Integer clazzId;
    private Integer page = 1;
    private Integer pageSize = 10;
}
