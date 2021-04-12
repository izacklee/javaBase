package com.m.mvc.web;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileEntity {

    private InputStream input;
    private String filename;
    private String suffix;
    private Integer length;

    public void write(String path) {
        OutputStream output;
        try {
            output = new FileOutputStream(new File(path));
            // IOUtils是IO工具类
            IOUtils.copy(input, output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public InputStream getInput() {
        return input;
    }
    public void setInput(InputStream input) {
        this.input = input;
    }
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public String getSuffix() {
        return suffix;
    }
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
