package com.m.entity;

public class FileItem {
    private String fileName;
    private Integer fileType;
    private String filePath;
    private Integer isDir;

    public FileItem() {
    }

    public FileItem(String fileName, Integer fileType, String filePath, Integer isDir) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.filePath = filePath;
        this.isDir = isDir;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getIsDir() {
        return isDir;
    }

    public void setIsDir(Integer isDir) {
        this.isDir = isDir;
    }

}
