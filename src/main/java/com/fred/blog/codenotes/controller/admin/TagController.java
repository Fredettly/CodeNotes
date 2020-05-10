package com.fred.blog.codenotes.controller.admin;

import com.fred.blog.codenotes.model.Tag;
import com.fred.blog.codenotes.service.TagService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xwx_ on 2020/5/1
 */
@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tag")
    public String tagPage(Model model) {
        PageInfo<Tag> tags = tagService.tags();
        model.addAttribute("tags", tags);
        return "admin/tag";
    }

    @PostMapping("/addTag")
    public String addTag(@RequestParam(name = "tag") String tagName) {
        tagService.addTag(tagName);
        return "redirect:tag";
    }

    @GetMapping("/rmTag")
    public String removeTag(@RequestParam(name = "id") Long id) {
        tagService.removeTagById(id);
        return "redirect:/admin/tag";
    }
}
