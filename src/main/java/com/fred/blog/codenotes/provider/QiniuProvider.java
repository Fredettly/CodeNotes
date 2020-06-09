package com.fred.blog.codenotes.provider;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * Created by xwx_ on 2020/6/6
 */
@Component
public class QiniuProvider {

    @Value("${qiniu.access_token}")
    private String AK;
    @Value("${qiniu.secret_token}")
    private String SK;
    @Value("${qiniu.bucket}")
    private String BUCKET;
    @Value("${qiniu.domain_of_bucket}")
    private String DOMAIN_OF_BUCKET;


    public String upload(InputStream inputStream) throws QiniuException {
        String filename = UUID.randomUUID().toString();
        System.out.println(SK);
        Auth auth = Auth.create(AK, SK);
        String token = auth.uploadToken(BUCKET);
        System.out.println(token);
        Configuration cfg = new Configuration(Region.huanan());
        UploadManager uploadManager = new UploadManager(cfg);
        Response response = uploadManager.put(inputStream, filename, token, null, null);
        if (response.isOK()) {
            return download(filename);
        }
        return null;
    }

    public String download(String filename) {
        Auth auth = Auth.create(AK, SK);
        String publicUrl = String.format("%s/%s", DOMAIN_OF_BUCKET, filename);
        long expireInSeconds = 31536000;
        return auth.privateDownloadUrl(publicUrl, expireInSeconds);
    }
}
