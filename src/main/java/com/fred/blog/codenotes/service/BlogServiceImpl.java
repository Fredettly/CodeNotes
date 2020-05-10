package com.fred.blog.codenotes.service;

import com.fred.blog.codenotes.dto.BlogDTO;
import com.fred.blog.codenotes.mapper.BlogMapper;
import com.fred.blog.codenotes.mapper.UserMapper;
import com.fred.blog.codenotes.model.Blog;
import com.fred.blog.codenotes.model.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwx_ on 2020/4/29
 */

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<BlogDTO> findAllBlog(Integer pageNum, String tag) {
        if (tag == null || tag.equals("")) {
            PageHelper.startPage(pageNum, 4, "gmt_modified desc");
            List<BlogDTO> blogs = blogMapper.findAllBlog();
            PageInfo<BlogDTO> pageInfo = new PageInfo<>(blogs);
            return packDTO(pageInfo);
        } else {
            PageHelper.startPage(pageNum, 4, "gmt_modified desc");
            List<BlogDTO> blogs = blogMapper.findByTag(tag);
            PageInfo<BlogDTO> pageInfo = new PageInfo<>(blogs);
            return packDTO(pageInfo);
        }
    }

    @Override
    public void deleteBlogById(Long id) {
        blogMapper.deleteBlogById(id);
    }

    @Override
    public void saveOrUpdate(com.fred.blog.codenotes.model.Blog blog) {
        if (blog.getId() == null) {
            //id不存在，添加
            blog.setGmtCreate(System.currentTimeMillis());
            blog.setGmtModified(System.currentTimeMillis());
            blog.setViewCount(0);
            blog.setCommentCount(0);
            blogMapper.saveBlog(blog);
        } else {
            //id存在，更新
            blog.setGmtModified(System.currentTimeMillis());
            blogMapper.updateBlog(blog);
        }

    }

    @Override
    public BlogDTO getById(Long id) {
        Blog blog = blogMapper.getById(id);
        BlogDTO blogDTO = new BlogDTO();
        Long uid = blog.getCreator();
        User user = userMapper.findById(uid);
        BeanUtils.copyProperties(blog, blogDTO);
        blogDTO.setUsername(user.getUsername());
        blogDTO.setAvatar(user.getAvatar());
        return blogDTO;
    }

    @Override
    public void incView(Long id) {
        Blog blog = new Blog();
        blog.setId(id);
        blog.setViewCount(1);
        blogMapper.incView(blog);
    }

    private PageInfo<BlogDTO> packDTO(PageInfo<BlogDTO> pageInfo) {
        List<BlogDTO> blogDTOList = new ArrayList<>();
        for (BlogDTO blog : pageInfo.getList()) {
            Long uid = blog.getCreator();
            User user = userMapper.findById(uid);
            BlogDTO blogDTO = new BlogDTO();
            BeanUtils.copyProperties(blog, blogDTO);
            blogDTO.setUsername(user.getUsername());
            blogDTO.setAvatar(user.getAvatar());
            blogDTOList.add(blogDTO);
        }
        pageInfo.setList(blogDTOList);
        return pageInfo;
    }

}
