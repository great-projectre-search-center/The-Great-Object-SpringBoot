package com.hdgs.great.object.repository;

import com.hdgs.great.object.domain.Reward;
import org.apache.ibatis.annotations.Select;

public interface RewardRepository {
    /**
     * 积分变动
     * @param reward
     * @return
     */
    public boolean change(Reward reward);


    /**
     * 获取某人的交易明细
     * @param open_Id
     * @return
     */
    public Reward[] getDetails(String open_Id);

    /**
     * 获取某人最后一次变动
     * @param open_Id
     * @return
     */
    public Reward getLastChanged(String open_Id);
}
