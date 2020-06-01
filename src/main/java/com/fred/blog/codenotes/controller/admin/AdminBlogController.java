package com.fred.blog.codenotes.controller.admin;

import com.fred.blog.codenotes.dto.BlogDTO;
import com.fred.blog.codenotes.model.Tag;
import com.fred.blog.codenotes.service.BlogService;
import com.fred.blog.codenotes.service.TagService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Created by xwx_ on 2020/4/29
 */
@Controller
@RequestMapping("/admin")
public class AdminBlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TagService tagService;

    @GetMapping("/index")
    public String indexPage(@RequestParam(name = "tag", required = false) String tag,
                            @RequestParam(name = "pageNum", defaultValue = "1") int pageNum, Model model) {
        PageInfo<BlogDTO> list = blogService.findAllBlog( pageNum, tag);
        PageInfo<Tag> tags = tagService.tags();
        model.addAttribute("list", list);
        model.addAttribute("tags", tags);
        model.addAttribute("tag", tag);
        return "admin/index";
    }

    @GetMapping("blog/{id}/delete")
    public String deleteById(@PathVariable(name = "id") Long id) {
        blogService.deleteBlogById(id);
        return "redirect:/admin/index";
    }


}
