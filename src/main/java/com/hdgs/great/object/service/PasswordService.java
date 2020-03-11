package com.hdgs.great.object.service;


public interface PasswordService {

    /**
     * 密码加密
     *
     * @param rawPassword
     * @return
     */
    public String encode(CharSequence rawPassword);

    /**
     * 密码匹配
     *
     * @param rawPassword
     * @param encodedPassword
     * @return
     */
    public boolean matches(CharSequence rawPassword, String encodedPassword);
}
