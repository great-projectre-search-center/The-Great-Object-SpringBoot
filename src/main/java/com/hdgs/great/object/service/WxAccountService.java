package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.WxAccount;
import org.apache.ibatis.annotations.*;

public interface WxAccountService {

    public WxAccount getWxAccount(int id);

    public WxAccount addAccount(String nickName, String password);

    /**
     * 登录凭证校验
     *
     * @param js_code
     * @return
     */
    public String code2Session(String js_code);

    /**
     * 昵称是否存在
     * @param nickName
     * @return
     */
    public boolean isNicknameExist(String nickName);

}
