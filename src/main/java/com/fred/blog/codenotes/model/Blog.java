package com.fred.blog.codenotes.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by xwx_ on 2020/4/29
 */
@Data
public class Blog implements Serializable {

    private Long id;
    private String title;
    private String content;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer viewCount;
    private Integer commentCount;
    private String tag;
    private Long creator;
    private String image;
}
