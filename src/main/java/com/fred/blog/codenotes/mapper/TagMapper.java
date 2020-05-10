package com.fred.blog.codenotes.mapper;

import com.fred.blog.codenotes.model.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xwx_ on 2020/4/29
 */
@Repository
public interface TagMapper {

    List<Tag> findAllTag();

    void addTag(String tagName);

    void removeTagById(Long id);
}
