package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
封装登陆结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfo {
    private String username;
    private String name;
    private Integer id;
    private String token;
}
