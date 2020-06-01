package com.fred.blog.codenotes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan("com.fred.blog.codenotes.mapper")
@SpringBootApplication
public class CodenotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodenotesApplication.class, args);
    }

}
