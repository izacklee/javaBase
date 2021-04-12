package com.m.entity;

import java.util.Date;

public class UserVolume {
    private Integer id;
    private Integer size;
    private Integer defSize;
    private Integer maxSize;
    private Date expireTime;
    private String appid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getDefSize() {
        return defSize;
    }

    public void setDefSize(Integer defSize) {
        this.defSize = defSize;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    @Override
    public String toString() {
        return "UserVolume{" +
                "id=" + id +
                ", size=" + size +
                ", defSize=" + defSize +
                ", maxSize=" + maxSize +
                ", expireTime=" + expireTime +
                ", appid='" + appid + '\'' +
                '}';
    }
}
