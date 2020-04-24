package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.Reward;
import com.hdgs.great.object.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardServiceImpl implements RewardService {

    @Autowired
    RewardRepository rewardRepository;
    /**
     * 变动积分
     *
     * @param reward
     * @param lastReward
     * @return
     */
    @Override
    public boolean change(Reward reward, int lastReward) {
        return rewardRepository.change(reward,lastReward)?true:false;
    }

    /**
     * 获取用户的积分变动明细
     *
     * @param openid
     * @return
     */
    @Override
    public Reward[] getDetails(String openid) {
        return rewardRepository.getDetails(openid);
    }

    /**
     * 获取用户最后一次变动信息
     *
     * @param openid
     * @return
     */
    @Override
    public Reward getLastChanged(String openid) {
        return rewardRepository.getLastChanged(openid);
    }
}
