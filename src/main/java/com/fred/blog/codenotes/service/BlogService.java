package com.fred.blog.codenotes.service;

import com.fred.blog.codenotes.dto.BlogDTO;
import com.fred.blog.codenotes.model.Blog;
import com.github.pagehelper.PageInfo;

/**
 * Created by xwx_ on 2020/4/29
 */
public interface BlogService {

    PageInfo<BlogDTO> findAllBlog(Integer pageNum, String search);

    void deleteBlogById(Long id);

    void saveOrUpdate(Blog blog);

    BlogDTO getById(Long id);


    void incView(Long id);
}
