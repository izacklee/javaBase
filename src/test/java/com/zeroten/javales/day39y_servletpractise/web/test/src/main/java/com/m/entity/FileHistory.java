package com.m.entity;

import java.util.Date;

public class FileHistory {
    private Integer id;
    private String fileName;
    private String FilePath;
    private Integer fileType;
    private Integer fileSize;
    private Integer historyStatus;
    private String appid;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String filePath) {
        FilePath = filePath;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public Integer getHistoryStatus() {
        return historyStatus;
    }

    public void setHistoryStatus(Integer historyStatus) {
        this.historyStatus = historyStatus;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "FileHistory{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", FilePath='" + FilePath + '\'' +
                ", fileType=" + fileType +
                ", fileSize=" + fileSize +
                ", historyStatus=" + historyStatus +
                ", appid='" + appid + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
