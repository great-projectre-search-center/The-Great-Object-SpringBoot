package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.WxAccount;

public interface WxAccountService {

    /**
     * 根据用户id获取用户信息
     * @param uid 用户id
     * @return 用户信息
     */
    public WxAccount getWxAccount(int uid);

    /**
     * 根据用户的openid获取用户信息
     * @param openId
     * @return
     */
    public WxAccount getWxAccountByOpenId(String openId);

    /**
     * 添加新的用户
     * @param nickName 昵称
     * @param password 密码
     * @return 新用户的信息
     */
    public WxAccount addAccount(String nickName, String password);

    /**
     * 登录凭证校验
     *
     * @param js_code
     * @return
     */
    public String code2Session(String js_code);

    /**
     * 检查昵称是否存在
     * @param nickName
     * @return
     */
    public boolean isNicknameExist(String nickName);

}
