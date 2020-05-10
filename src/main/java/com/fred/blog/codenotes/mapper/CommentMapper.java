package com.fred.blog.codenotes.mapper;

import com.fred.blog.codenotes.dto.CommentDTO;
import com.fred.blog.codenotes.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xwx_ on 2020/5/6
 */
@Repository
public interface CommentMapper {

    void insert(Comment comment);

    List<CommentDTO> findByBlogId(Long parentId);
}
