package com.fred.blog.codenotes.controller.client;

import com.fred.blog.codenotes.dto.BlogDTO;
import com.fred.blog.codenotes.model.Tag;
import com.fred.blog.codenotes.service.BlogService;
import com.fred.blog.codenotes.service.TagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by xwx_ on 2020/5/2
 */
@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String index(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, Model model) {
        PageInfo<BlogDTO> list = blogService.findAllBlog(pageNum, "");
        PageInfo<Tag> tags = tagService.tags();
        model.addAttribute("tag", tags);
        model.addAttribute("list", list);
        return "index";
    }

}
