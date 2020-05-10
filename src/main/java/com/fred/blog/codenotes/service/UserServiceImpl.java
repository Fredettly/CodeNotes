package com.fred.blog.codenotes.service;

import com.fred.blog.codenotes.dto.GithubUser;
import com.fred.blog.codenotes.mapper.UserMapper;
import com.fred.blog.codenotes.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xwx_ on 2020/4/28
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkLogin(String username, String password) {
        return userMapper.findByUsernameAndPassword(username, password);
    }

    @Override
    public void createOrUpdate(GithubUser githubUser) {
        Long accountId = githubUser.getAccountId();
        GithubUser user = userMapper.findGithubByAccountId(accountId);
        if (user == null) {
            githubUser.setGmtCreate(System.currentTimeMillis());
            githubUser.setGmtModified(githubUser.getGmtCreate());
            userMapper.insert(githubUser);
        }else {
            GithubUser updateUser = new GithubUser();
            BeanUtils.copyProperties(user, updateUser);
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setName(user.getName());
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setToken(githubUser.getToken());
            userMapper.updateGithubUser(updateUser);
        }
    }
}
