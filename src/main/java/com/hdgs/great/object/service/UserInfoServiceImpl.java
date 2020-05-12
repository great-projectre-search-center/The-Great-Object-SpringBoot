package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.WxAccount;
import com.hdgs.great.object.repository.WxAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    UploadFileService uploadFileService;

    @Autowired
    WxAccountRepository wxAccountRepository;


    public String changeAvatar(WxAccount wxAccount, MultipartFile multipartFile) throws IOException {
        String a = uploadFileService.uuidFile(multipartFile, "avatar/");
        wxAccount.setAvatar_Url("/avatar/" + a);
        wxAccountRepository.updateByWxAccount(wxAccount);
        return a;

    }


}
