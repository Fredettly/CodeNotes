package com.fred.blog.codenotes.service;

import com.fred.blog.codenotes.model.Tag;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TagService {

    PageInfo<Tag> tags();

    void addTag(String tagName);

    void removeTagById(Long id);
}
