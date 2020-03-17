package com.hdgs.great.object.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public interface UploadFileService {
    /**
     * 获取一个uuid命名的文件名
     * @param file
     * @param subpath
     * @return
     * @throws IOException
     */
    public String uuidFile(MultipartFile file, String subpath) throws IOException;

    /**
     * 上传文件
     * @param file
     * @param basePath
     * @param subpath
     * @param overwrite
     * @return
     * @throws IOException
     */
    public boolean uploadFile(MultipartFile file, String basePath, String subpath, boolean overwrite) throws IOException;
}
