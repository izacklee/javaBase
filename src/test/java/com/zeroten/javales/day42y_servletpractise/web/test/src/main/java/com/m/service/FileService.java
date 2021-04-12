package com.m.service;

import com.m.entity.FileCloud;
import com.m.entity.FileHistory;

public interface FileService {

    public int insertFileCloud(FileCloud fc);
    public int insertFileHistory(FileHistory fh);
    public int updateFileHistory(FileHistory fh);

}
