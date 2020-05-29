package com.hdgs.great.object.repository;


import com.hdgs.great.object.domain.Notification;

public interface NotificationRepository {


    /**
     * 插入新的通知数据
     * @param notification 通知数据
     * @return 受影响的行数
     */
    Integer insertByNotification(Notification notification);

    /**
     *根据通知数据的id和被通知的openid删除对应的通知数据
     * @param to_Open_Id 被通知的openid
     * @param nid 通知id
     * @return 受影响的行数
     */
    Integer delete(String to_Open_Id,Integer nid);

    /**
     * 查询通知的数量
     * @return 通知数据的数量
     */
    Integer countAll();

    /**
     * 查询全部系统通知
     * @return 系统通知集合
     */
    Notification[] findAllSystemNotification(String to_Open_Id);

    /**
     * 根据被通知的openid查询通知数据
     * @param to_Open_Id 被通知的openid
     * @return 通知的数据集合
     */
    Notification[] findByToopenid(String to_Open_Id);

    /**
     * 根据通知id查询对应通知数据
     * @param nid 通知id
     * @return 通知数据
     */
    Notification findById(Integer nid);

}
