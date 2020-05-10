package com.fred.blog.codenotes.dto;

import lombok.Data;

/**
 * Created by xwx_ on 2020/5/4
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
