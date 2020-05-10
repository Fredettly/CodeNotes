package com.fred.blog.codenotes.service;

import com.fred.blog.codenotes.dto.BlogDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by xwx_ on 2020/4/29
 */
public interface BlogService {

    PageInfo<BlogDTO> findAllBlog(Integer pageNum, String tag);

    void deleteBlogById(Long id);

    void saveOrUpdate(com.fred.blog.codenotes.model.Blog blog);

    BlogDTO getById(Long id);


    void incView(Long id);
}
