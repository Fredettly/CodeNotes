package com.fred.blog.codenotes.exception;

/**
 * Created by xwx_ on 2020/5/6
 */
public class CustomizeException extends RuntimeException {
    private String message;
    private Integer code;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
