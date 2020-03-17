package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.WxAccount;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserInfoService {
    /**
     * 更改头像
     * @param wxAccount
     * @param multipartFile
     * @return
     * @throws IOException
     */
    String changeAvatar(WxAccount wxAccount, MultipartFile multipartFile) throws IOException;
}
