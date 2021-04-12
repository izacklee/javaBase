package com.m.service;

import com.m.entity.FileItem;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public interface HDFSService {
    public boolean mkdir(String path);
    public List<FileItem> ListFile(String path);
    public boolean upload(InputStream in, String path);
    public boolean download(OutputStream out, String path);
}
