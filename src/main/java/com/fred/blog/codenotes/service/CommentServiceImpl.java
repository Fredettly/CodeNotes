package com.fred.blog.codenotes.service;

import com.fred.blog.codenotes.dto.CommentDTO;
import com.fred.blog.codenotes.dto.GithubUser;
import com.fred.blog.codenotes.exception.CustomizeErrorCode;
import com.fred.blog.codenotes.exception.CustomizeException;
import com.fred.blog.codenotes.mapper.BlogMapper;
import com.fred.blog.codenotes.mapper.CommentMapper;
import com.fred.blog.codenotes.mapper.UserMapper;
import com.fred.blog.codenotes.model.Blog;
import com.fred.blog.codenotes.model.Comment;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwx_ on 2020/5/6
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }
        Long id = comment.getParentId();
        Blog blog = blogMapper.getById(id);
        if (blog == null) {
            throw new CustomizeException(CustomizeErrorCode.BLOG_NOT_FOUND);
        }
        commentMapper.insert(comment);
        blog.setCommentCount(1);
        blogMapper.incCommentCount(blog);
    }

    @Override
    public PageInfo<CommentDTO> findByBlogId(Long id, Integer pageNum) {
        PageHelper.startPage(pageNum, 5, "gmt_create desc");
        List<CommentDTO> commentDTO = commentMapper.findByBlogId(id);
        PageInfo<CommentDTO> pageInfo = new PageInfo<>(commentDTO);
        return packDTO(pageInfo);
    }


    private PageInfo<CommentDTO> packDTO(PageInfo<CommentDTO> pageInfo) {
        List<CommentDTO> CommentDTOList = new ArrayList<>();
        for (CommentDTO comment : pageInfo.getList()) {
            CommentDTO commentDTO = new CommentDTO();
            GithubUser user = userMapper.findGithubById(comment.getCommentator());
            BeanUtils.copyProperties(comment, commentDTO);
            commentDTO.setGithubUser(user);
            CommentDTOList.add(commentDTO);
        }
        pageInfo.setList(CommentDTOList);
        return pageInfo;
    }


}
