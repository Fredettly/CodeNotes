package com.fred.blog.codenotes.dto;

import com.fred.blog.codenotes.exception.CustomizeErrorCode;
import com.fred.blog.codenotes.exception.CustomizeException;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by xwx_ on 2020/5/6
 */
@Data
public class ResultDTO implements Serializable {
    private Integer code;
    private String message;

    private static ResultDTO errorOf(Integer code, String message) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.code = code;
        resultDTO.message = message;
        return resultDTO;
    }


    public static ResultDTO errorOf(CustomizeErrorCode errorCode) {
        return errorOf(errorCode.getCode(), errorCode.getMessage());
    }

    public static ResultDTO errorOf(CustomizeException e) {
        return errorOf(e.getCode(), e.getMessage());
    }

    public static ResultDTO okOf() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        return resultDTO;
    }
}
