package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.Reward;

public interface RewardService {
    /**
     * 变动积分
     * @param reward
     * @param lastReward
     * @return
     */
    public boolean change(Reward reward);

    /**
     * 获取用户的积分变动明细
     * @param openid
     * @return
     */
    public Reward[] getDetails(String openid);

    /**
     * 获取用户最后一次变动信息
     * @param openid
     * @return
     */
    public Reward getLastChanged(String openid);

}
