package com.fred.blog.codenotes.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwx_ on 2020/4/29
 */
@Data

public class Tag {

    private Long id;
    private String name;
    private List<Blog> blogs = new ArrayList<>();
}
