package com.hdgs.great.object.service;

import com.hdgs.great.object.domain.Reward;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class RewardServiceTests {

    @Autowired
    RewardService rewardService;

    @Test
    public void change(){
        Reward reward=new Reward();
        reward.setOpen_Id("aaa");
        reward.setDate(new Date());
        reward.setChanged(100);
        reward.setMatter("加分了！！！！");

        rewardService.change(reward);
    }
    @Test
    public void getDetails(){
        Reward[] reward=rewardService.getDetails("oV9m45b5S1RGPf6gTCXu3a5dAgF4");
        System.out.println(reward);
    }
    @Test
    public void getLastChanged(){
        Reward reward=rewardService.getLastChanged("oV9m45b5S1RGPf6gTCXu3a5dAgF4");
        System.out.println(reward);

    }

}
