package com.m.util;

public class BaseUtil {

    /**
     * 获取文件类型
     * @param fileName
     * @return
     */
    public static Integer getFileType(String fileName) {

        String[] ps = fileName.split("\\."); // split分割必须\\. 否则将返回空
        String fileType = ps[ps.length - 1];
        switch(fileType) {
            case "xls":
                return 1;
            case "xlsx":
                return 1;
            case "ppt":
                return 2;
            case "pptx":
                return 2;
            case "doc":
                return 3;
            case "docx":
                return 3;
        }
        return 0;
    }
}
