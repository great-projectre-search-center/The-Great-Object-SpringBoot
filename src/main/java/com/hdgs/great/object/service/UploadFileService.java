package com.hdgs.great.object.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public interface UploadFileService {
    public String uuidFile(MultipartFile file, String subpath) throws IOException;


    public boolean uploadFile(MultipartFile file, String basePath, String subpath, boolean overwrite) throws IOException;
}
