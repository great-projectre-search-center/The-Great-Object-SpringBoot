package com.hdgs.great.object.domain;

import java.util.Date;

/**
 * 评价管理的实体类
 * @author jingfeng999
 */
public class Appraise {
    Integer aid; //评价id
    Integer oid; //订单id
    Integer grade; //评价等级0，1，2，3
    String content; //评价内容

    //日志
    String created_User;
    Date created_Time;
    String modified_User;
    Date modified_Time;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_User() {
        return created_User;
    }

    public void setCreated_User(String created_User) {
        this.created_User = created_User;
    }

    public Date getCreated_Time() {
        return created_Time;
    }

    public void setCreated_Time(Date created_Time) {
        this.created_Time = created_Time;
    }

    public String getModified_User() {
        return modified_User;
    }

    public void setModified_User(String modified_User) {
        this.modified_User = modified_User;
    }

    public Date getModified_Time() {
        return modified_Time;
    }

    public void setModified_Time(Date modified_Time) {
        this.modified_Time = modified_Time;
    }

    @Override
    public String toString() {
        return "Appraise{" +
                "aid=" + aid +
                ", oid=" + oid +
                ", grade=" + grade +
                ", content='" + content + '\'' +
                ", created_User='" + created_User + '\'' +
                ", created_Time=" + created_Time +
                ", modified_User='" + modified_User + '\'' +
                ", modified_Time=" + modified_Time +
                '}';
    }
}
