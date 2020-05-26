package com.fred.blog.codenotes.utils;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

/**
 * Created by xwx_ on 2020/5/26
 */
public class JasyptUtils implements CommandLineRunner {

    @Autowired
    private StringEncryptor stringEncryptor;

    public static void main(String[] args) {
        SpringApplication.run(JasyptUtils.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
