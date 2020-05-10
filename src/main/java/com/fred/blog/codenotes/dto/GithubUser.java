package com.fred.blog.codenotes.dto;

import lombok.Data;

/**
 * Created by xwx_ on 2020/5/4
 */
@Data
public class GithubUser {
    private Long id;
    private Long accountId;
    private String name;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
