package com.fred.blog.codenotes.model;

import lombok.Data;

/**
 * Created by xwx_ on 2020/5/6
 */
@Data
public class Comment {
    private Long id;
    private Long parentId;
    private String content;
    private Long commentator;
    private Long gmtCreate;
}
