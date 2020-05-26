package com.fred.blog.codenotes.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by xwx_ on 2020/5/4
 */
@Data
public class GithubUser implements Serializable {
    private Long id;
    private Long accountId;
    private String name;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
