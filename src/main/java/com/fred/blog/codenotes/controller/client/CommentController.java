package com.fred.blog.codenotes.controller.client;

import com.fred.blog.codenotes.dto.GithubUser;
import com.fred.blog.codenotes.dto.ResultDTO;
import com.fred.blog.codenotes.exception.CustomizeErrorCode;
import com.fred.blog.codenotes.model.Comment;
import com.fred.blog.codenotes.model.User;
import com.fred.blog.codenotes.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xwx_ on 2020/5/6
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;


    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object postComment(@RequestBody Comment comment,
                              HttpServletRequest request) {
        GithubUser user = (GithubUser) request.getSession().getAttribute("user");
        if (user == null) return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        if (comment.getContent() == null || comment.getContent().equals("")) {
            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }
        comment.setCommentator(user.getId());
        comment.setGmtCreate(System.currentTimeMillis());
        commentService.insert(comment);
        return ResultDTO.okOf();
    }
}
