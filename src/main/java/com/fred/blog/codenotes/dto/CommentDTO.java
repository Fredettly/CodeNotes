package com.fred.blog.codenotes.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by xwx_ on 2020/5/8
 */
@Data
public class CommentDTO implements Serializable {
    private Long id;
    private Long parentId;
    private String content;
    private Long commentator;
    private Long gmtCreate;
    private GithubUser githubUser;
}
