package com.hdgs.great.object.domain;

public class Notification {

    int id;
    String fromopenid;
    String toopenid;
    String title;
    String msg;

    protected Notification() {
    }

    public Notification(int id, String fromopenid, String toopenid, String title, String msg) {
        this.id = id;
        this.fromopenid = fromopenid;
        this.toopenid = toopenid;
        this.title = title;
        this.msg = msg;
    }

    public Notification(String fromopenid, String toopenid, String title, String msg) {
        this.fromopenid = fromopenid;
        this.toopenid = toopenid;
        this.title = title;
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromopenid() {
        return fromopenid;
    }

    public void setFromopenid(String fromopenid) {
        this.fromopenid = fromopenid;
    }

    public String getToopenid() {
        return toopenid;
    }

    public void setToopenid(String toopenid) {
        this.toopenid = toopenid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
