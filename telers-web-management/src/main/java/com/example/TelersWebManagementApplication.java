package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;
@ServletComponentScan//开启了SpringBoot对Servlet组件的支持
@SpringBootApplication
public class TelersWebManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelersWebManagementApplication.class, args);
    }

}
