package com.hdgs.great.object.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class UploadFileServiceImpl implements UploadFileService{
    String uploadFileBasePath;
    String userResourceBasePath;


    public UploadFileServiceImpl(@Value("${xyz.zxcwxy999.uploadedfilepath}") String path, @Value("${xyz.zxcwxy999.userresource}") String path2) {

        if (path.endsWith("/")) {
            this.uploadFileBasePath = path;
        } else {
            this.uploadFileBasePath = path + "/";
        }

        if (path2.endsWith("/")) {
            this.userResourceBasePath = path;
        } else {
            this.userResourceBasePath = path + "/";
        }

    }


    public String uuidFile(MultipartFile file, String subpath) throws IOException {

        if (!subpath.endsWith("/")) {
            subpath = subpath + "/";
        }
        String tempName = UUID.randomUUID().toString();
        String originalFilename = file.getOriginalFilename();
        String extname = "";

        if (originalFilename.contains(".")) {
            String[] namepart = originalFilename.split("\\.");
            extname = namepart[namepart.length - 1];
        }
        if (!extname.equals("")) {
            tempName = tempName + "." + extname;
        }
        String pathname = uploadFileBasePath + subpath + tempName;

        File tempFile = new File(pathname);
        file.transferTo(tempFile);

        return tempName;
    }


    public boolean uploadFile(MultipartFile file, String basePath, String subpath, boolean overwrite) throws IOException {

        if (!subpath.endsWith("/")) {
            subpath = subpath + "/";
        }
        String originalFilename = file.getOriginalFilename();
        String pathname = basePath + subpath + originalFilename;

        File tempFile = new File(pathname);

        if (overwrite != true) {
            if (tempFile.exists()) {
                return false;
            }
        }
        file.transferTo(tempFile);

        return true;
    }

}
