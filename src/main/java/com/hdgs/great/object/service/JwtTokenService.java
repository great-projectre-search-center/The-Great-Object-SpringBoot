package com.hdgs.great.object.service;


public interface JwtTokenService {

    /**
     * 生成令牌
     *
     * @param openid
     * @return
     */
    public String generateToken(String openid);

    /**
     * 验证令牌
     *
     * @param token
     * @return
     */
    public Integer VerifyToken(String token);
}
