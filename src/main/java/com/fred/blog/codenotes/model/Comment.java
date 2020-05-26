package com.fred.blog.codenotes.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by xwx_ on 2020/5/6
 */
@Data
public class Comment implements Serializable {
    private Long id;
    private Long parentId;
    private String content;
    private Long commentator;
    private Long gmtCreate;
}
