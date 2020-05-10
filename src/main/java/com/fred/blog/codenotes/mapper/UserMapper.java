package com.fred.blog.codenotes.mapper;

import com.fred.blog.codenotes.dto.GithubUser;
import com.fred.blog.codenotes.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by xwx_ on 2020/4/28
 */
@Repository
public interface UserMapper {

    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);


    User findById(@Param("uid") Long id);

    GithubUser findGithubByAccountId(@Param("accountId") Long accountId);

    void insert(GithubUser user);

    void updateGithubUser(GithubUser updateUser);

    GithubUser findByToken(@Param("token") String token);

    GithubUser findGithubById(Long id);
}
