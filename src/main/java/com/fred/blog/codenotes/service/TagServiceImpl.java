package com.fred.blog.codenotes.service;

import com.fred.blog.codenotes.mapper.TagMapper;
import com.fred.blog.codenotes.model.Tag;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xwx_ on 2020/4/29
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    public PageInfo<Tag> tags() {
        PageHelper.startPage(1,100);
        List<Tag> tag = tagMapper.findAllTag();
        return new PageInfo<>(tag);
    }

    @Override
    public void addTag(String tagName) {
        tagMapper.addTag(tagName);
    }

    @Override
    public void removeTagById(Long id) {
        tagMapper.removeTagById(id);
    }

}
