package com.fred.blog.codenotes.mapper;

import com.fred.blog.codenotes.dto.BlogDTO;
import com.fred.blog.codenotes.model.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper {

    List<BlogDTO> findAllBlog();

    void deleteBlogById(Long id);

    void saveBlog(Blog blog);

    Blog getById(Long id);

    void updateBlog(Blog blog);

    List<BlogDTO> findByTag(@Param("tag") String tag);

    void incView(Blog blog);

    void incCommentCount(Blog blog);

    Integer countBlog();
}
