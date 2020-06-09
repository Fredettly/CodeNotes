package com.fred.blog.codenotes.controller.admin;

import com.fred.blog.codenotes.dto.FileDTO;
import com.fred.blog.codenotes.provider.QiniuProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by xwx_ on 2020/6/6
 */
@Controller
public class FileController {

    @Autowired
    private QiniuProvider qiniuProvider;

    @RequestMapping("/file/upload")
    @ResponseBody
    public FileDTO upload(HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("editormd-image-file");
        try {
            String fileURL = qiniuProvider.upload(file.getInputStream());
            FileDTO fileDTO = new FileDTO();
            fileDTO.setSuccess(1);
            fileDTO.setUrl(fileURL);
            return fileDTO;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
