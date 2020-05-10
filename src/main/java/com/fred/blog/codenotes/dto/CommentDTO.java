package com.fred.blog.codenotes.dto;

import lombok.Data;

/**
 * Created by xwx_ on 2020/5/8
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private String content;
    private Long commentator;
    private Long gmtCreate;
    private GithubUser githubUser;
}
