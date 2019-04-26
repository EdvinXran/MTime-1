package com.stylefeng.guns.rest.modular.order.alipay.utils;

import com.aliyun.oss.OSSClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Gavin
 * on 2019/4/11 16:46
 */
public class OSSUploadUtils {
    static String bucketName  = "mtime-alipay";
    static OSSClient  ossClient;
    public static OSSClient initOOSClient(){
        final String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        final String accessKeyId = "LTAIUNOPybiWBx8C";
        final String accessKeySecret = "Q75V2Jyu3d3HZbIkK7MaMWQ5bkxiSt";
        ossClient = new OSSClient(endpoint,accessKeyId,accessKeySecret);
        return ossClient;
    }

    public static String saveFile(MultipartFile file, String endpoint) throws IOException {
        InputStream inputStream = file.getInputStream();
        String fileName  = file.getOriginalFilename();
        ossClient.putObject(bucketName,fileName,inputStream);
        ossClient.shutdown();
        int index = endpoint.indexOf("//");
        String substring = endpoint.substring(index+2);
        return fileName;
    }

}
