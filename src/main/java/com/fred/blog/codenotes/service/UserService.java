package com.fred.blog.codenotes.service;

import com.fred.blog.codenotes.dto.GithubUser;
import com.fred.blog.codenotes.model.User;

public interface UserService {
    User checkLogin(String username, String password);

    void createOrUpdate(GithubUser user);
}
