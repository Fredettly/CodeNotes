package com.fred.blog.codenotes.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by xwx_ on 2020/4/28
 */

@Data
public class User {

    private Long id;
    private String username;
    private String password;
    private String avatar;
    private Integer type;
    private Date createTime;
    private Date updateTime;

}
