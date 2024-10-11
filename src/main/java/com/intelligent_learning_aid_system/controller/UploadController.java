package com.intelligent_learning_aid_system.controller;

import com.intelligent_learning_aid_system.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String name, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传 {} {} {}", name, age, image);

        // 本地上传
        String originalFileName = image.getOriginalFilename();
//        image.transferTo(new File("E:\\BaiduNetdiskDownload\\day11-SpringBootWeb案例\\day11-SpringBootWeb案例\\讲义\\images\\" + originalFileName));

        // 构造唯一的文件名 -- uuid（通用唯一标识符）
        int index = originalFileName.lastIndexOf(".");
        String extrname = originalFileName.substring(index);
        String newFileName = UUID.randomUUID().toString() + extrname;
        log.info("新的文件名：{}", newFileName);

        image.transferTo(new File("E:\\BaiduNetdiskDownload\\day11-SpringBootWeb案例\\day11-SpringBootWeb案例\\讲义\\images\\" + newFileName));

        return Result.success();
    }
}
