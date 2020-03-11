package com.hdgs.great.object.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public interface PasswordService {

    /**
     * 密码加密
     * @param rawPassword
     * @return
     */
    public String encode(CharSequence rawPassword);

    /**
     * 密码匹配
     * @param rawPassword
     * @param encodedPassword
     * @return
     */
    public boolean matches(CharSequence rawPassword, String encodedPassword);
}
