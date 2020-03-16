package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.WxAccount;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserInfoService {
    String changAvatar(WxAccount wxAccount, MultipartFile multipartFile) throws IOException;
}
