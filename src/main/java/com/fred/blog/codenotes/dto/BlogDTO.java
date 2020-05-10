package com.fred.blog.codenotes.dto;

import com.fred.blog.codenotes.model.Blog;
import com.fred.blog.codenotes.model.User;
import lombok.Data;

/**
 * Created by xwx_ on 2020/5/4
 */
@Data
public class BlogDTO {
    private Long id;
    private String title;
    private String content;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer viewCount;
    private Integer commentCount;
    private String tag;
    private Long creator;
    private String username;
    private String avatar;
}
