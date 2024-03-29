package com.fred.blog.codenotes.controller.admin;

import com.fred.blog.codenotes.model.User;
import com.fred.blog.codenotes.service.BlogService;
import com.fred.blog.codenotes.service.TagService;
import com.fred.blog.codenotes.service.UserService;
import com.fred.blog.codenotes.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by xwx_ on 2020/4/28
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session,
                        RedirectAttributes attributes) {
        User admin = userService.checkLogin(username, MD5Utils.code(password));
        if (admin != null) {
            admin.setPassword(null);
            session.setAttribute("admin", admin);
            return "redirect:/admin/index";
        }
        attributes.addFlashAttribute("message", "用户名或密码错误");
        return "redirect:/admin";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}
