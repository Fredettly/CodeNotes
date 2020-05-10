package com.fred.blog.codenotes.controller.client;

import com.fred.blog.codenotes.dto.BlogDTO;
import com.fred.blog.codenotes.dto.CommentDTO;
import com.fred.blog.codenotes.model.Comment;
import com.fred.blog.codenotes.model.Tag;
import com.fred.blog.codenotes.service.BlogService;
import com.fred.blog.codenotes.service.CommentService;
import com.fred.blog.codenotes.service.TagService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by xwx_ on 2020/5/3
 */
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable(name = "id") Long id,
                       @RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                       Model model) {
        BlogDTO blog = blogService.getById(id);
        PageInfo<CommentDTO> commentDTO = commentService.findByBlogId(id,pageNum);
        PageInfo<Tag> tags = tagService.tags();
        blogService.incView(id);
        model.addAttribute("blog", blog);
        model.addAttribute("comment", commentDTO);
        model.addAttribute("tag", tags);
        return "blog";
    }
}
