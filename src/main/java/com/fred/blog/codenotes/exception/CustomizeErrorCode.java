package com.fred.blog.codenotes.exception;

@SuppressWarnings("ALL")
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    BLOG_NOT_FOUND(2001, "博客不见了，换个试试~"),
    SYS_ERROR(2002, "服务器发烧了，隔离片刻再来~"),
    NO_LOGIN(2003, "您还未登录，请登录后重试"),
    CONTENT_IS_EMPTY(2004, "留言内容不能为空"),
    TARGET_PARAM_NOT_FOUND(2005, "留言目标不存在"),
    REQUEST_FAILED(2006, "请求失败，请稍后重试~")
    ;


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
