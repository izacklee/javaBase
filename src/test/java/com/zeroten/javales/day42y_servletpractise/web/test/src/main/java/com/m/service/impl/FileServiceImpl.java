package com.m.service.impl;

import com.m.dao.FileCloudDao;
import com.m.dao.FileHistoryDao;
import com.m.entity.FileCloud;
import com.m.entity.FileHistory;
import com.m.service.FileService;

public class FileServiceImpl implements FileService {
    private FileCloudDao fileCloudDao;
    private FileHistoryDao fileHistoryDao;

    public FileCloudDao getFileCloudDao() {
        return fileCloudDao;
    }

    public void setFileCloudDao(FileCloudDao fileCloudDao) {
        this.fileCloudDao = fileCloudDao;
    }

    public FileHistoryDao getFileHistoryDao() {
        return fileHistoryDao;
    }

    public void setFileHistoryDao(FileHistoryDao fileHistoryDao) {
        this.fileHistoryDao = fileHistoryDao;
    }


    @Override
    public int insertFileCloud(FileCloud fc) {
        return fileCloudDao.insertFileCloud(fc);
    }

    @Override
    public int insertFileHistory(FileHistory fh) {
        return fileHistoryDao.insertFileHistory(fh);
    }

    @Override
    public int updateFileHistory(FileHistory fh) {
        return fileHistoryDao.updateFileHistory(fh);
    }
}
