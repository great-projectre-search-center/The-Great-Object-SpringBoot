package com.hdgs.great.object.repository;

import com.hdgs.great.object.domain.WxAccount;

import java.util.List;

public interface WxAccountRepository {

    /**
     * 插入新的用户数据
     * @param wxAccount 用户数据
     * @return 受影响的行数
     */
    Integer insertByNickNameEncodedPassword(WxAccount wxAccount);

    /**
     * 根据用户id修改用户信息
     * @param wxAccount 新的用户数据
     * @return 受影响的行数
     */
    Integer updateByWxAccount(WxAccount wxAccount);

    /**
     * 查询该用户名的用户数量
     * @param nick_Name
     * @return 受影响行数
     */
    Integer selectNicknamecount(String nick_Name);

    /**
     * 根据openid查询对应用户信息
     * @param open_Id 用户的唯一标识
     * @return 用户数据
     */
    WxAccount findByOpenid(String open_Id);

    /**
     * 根据用户id查询对应用户信息
     * @param uid
     * @return 用户数据
     */
    WxAccount findById(Integer uid);

    /**
     *  根据openid查询对应的昵称
     * @param open_Id 用户唯一标识
     * @return 用户昵称
     */
    String findNickNameByOpenid(String open_Id);

    /**
     * 查询所有相同用户名的用户数据
     * @param nick_Name
     * @return 用户数据集合
     */
    List<WxAccount> selectAllByNickName(String nick_Name);


}
