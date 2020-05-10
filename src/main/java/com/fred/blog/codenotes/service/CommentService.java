package com.fred.blog.codenotes.service;

import com.fred.blog.codenotes.dto.CommentDTO;
import com.fred.blog.codenotes.model.Comment;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CommentService {
    void insert(Comment comment);

    PageInfo<CommentDTO> findByBlogId(Long id, Integer pageNum);
}
