package com.fred.blog.codenotes.controller.admin;

import com.fred.blog.codenotes.dto.BlogDTO;
import com.fred.blog.codenotes.model.Blog;
import com.fred.blog.codenotes.model.Tag;
import com.fred.blog.codenotes.model.User;
import com.fred.blog.codenotes.service.BlogService;
import com.fred.blog.codenotes.service.TagService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by xwx_ on 2020/4/30
 */
@Controller
@RequestMapping("/admin")
public class PublishController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TagService tagService;


    @GetMapping("blog/publish")
    public String inputPage(Model model) {
        PageInfo<Tag> tags = tagService.tags();
        model.addAttribute("tags", tags);
        return "admin/publish";
    }


    @GetMapping("blog/publish/{id}")
    public String getById(@PathVariable(name = "id") Long id, Model model) {
        BlogDTO blogDTO = blogService.getById(id);
        model.addAttribute("title", blogDTO.getTitle());
        model.addAttribute("content", blogDTO.getContent());
        model.addAttribute("tag", blogDTO.getTag());
        model.addAttribute("id", blogDTO.getId());

        PageInfo<Tag> tags = tagService.tags();
        model.addAttribute("tags", tags);
        return "admin/publish";
    }

    @PostMapping("blog/publish")
    public String inputBlog(@RequestParam("title")String title,
                            @RequestParam("content")String content,
                            @RequestParam("tag")String tag,
                            @RequestParam("id")Long id,
                            HttpServletRequest request) {
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setTag(tag);
        blog.setId(id);
        User admin = (User) request.getSession().getAttribute("admin");
        blog.setCreator(admin.getId());
        blogService.saveOrUpdate(blog);
        return "redirect:/admin/index";
    }
}
