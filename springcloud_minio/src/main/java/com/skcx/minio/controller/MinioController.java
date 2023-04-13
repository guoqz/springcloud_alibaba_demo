package com.skcx.minio.controller;

import com.skcx.minio.config.MinIOConfig;
import com.skcx.minio.utils.MinIOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


@RestController
public class MinioController {
    @Autowired
    private MinIOConfig minIOConfig;


    /**
     * 上传
     *
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam(name = "file", required = false) MultipartFile file, HttpServletRequest request) {
        String originalFilename = file.getOriginalFilename();
        String bucketName = minIOConfig.getBucketName();
        String fileName = null;
        try {
            fileName = bucketName + "_" + System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));
            MinIOUtils.uploadFile(bucketName, fileName, file.getInputStream());
        } catch (Exception e) {
            return e.getMessage();
        }
        //返回图片链接
        return minIOConfig.getFileHost() + "/" + bucketName + "/" + fileName;
    }


    /**
     * 删除文件
     *
     * @param name
     * @return
     */
    @DeleteMapping
    public String delete(String name) {
        try {
            String bucketName = minIOConfig.getBucketName();
            boolean exist = MinIOUtils.isObjectExist(bucketName, name);
            if (exist) {
                MinIOUtils.removeFile(bucketName, name);
                return name + "删除成功";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
        return name + "不存在";
    }

}
