package com.hdgs.great.object.domain;

import java.util.Date;

public class Reward {
    String openid; //用户的id
    Date date;//时间
    String matter;//事情
    int changed;//变化
    int reward;//剩余积分

    public Reward() {
    }

    public Reward(String openid, Date date, String matter, int changed, int reward) {
        this.openid = openid;
        this.date = date;
        this.matter = matter;
        this.changed = changed;
        this.reward = reward;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public int getChanged() {
        return changed;
    }

    public void setChanged(int changed) {
        this.changed = changed;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "openid='" + openid + '\'' +
                ", date=" + date +
                ", matter='" + matter + '\'' +
                ", changed=" + changed +
                ", reward=" + reward +
                '}';
    }
}
