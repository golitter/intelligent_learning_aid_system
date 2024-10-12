package com.intelligent_learning_aid_system.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 阿里云 OSS 工具类
 */
@Component
public class AliOSSUtils {
    @Autowired
    private AliOSSUtilsProperties aliOSSUtilsProperties;

    public String upload(MultipartFile file) throws IOException {
        // 获取配置文件中的值
        String endpoint = aliOSSUtilsProperties.getEndpoint();
        String accessKeyId = aliOSSUtilsProperties.getAccessKeyId();
        String accessKeySecret = aliOSSUtilsProperties.getAccessKeySecret();
        String bucketName = aliOSSUtilsProperties.getBucketName();


        // 获取上传文件的  输入流
        InputStream inputStream = file.getInputStream();

        // 避免文件覆盖
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));

        // 上传到OSS
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, fileName, inputStream);

        //文件访问路径
        String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;

        // 关闭ossClient
        ossClient.shutdown();
        return url;// 把上传到oss的路径返回
    }

}
