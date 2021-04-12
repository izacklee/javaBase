package com.m.mvc.web;

import org.apache.commons.lang.StringUtils;

public enum FileType {

    JPG("image/jpeg", ".jpg"),
    PNG("image/png",".png"),
    PDF("application/pdf",".pdf"),
    TXT("text/plain",".txt"),
    DOC("application/msword",".doc"),
    DOCX("application/vnd.openxmlformats-officedocument.wordprocessingml.document",".docx"),
    XLS("application/vnd.ms-excel",".xls"),//wps的表格，是这个
    XLS2("application/octet-stream",".xls"),//如果Micro office的表格文件，对应content-type是这个
    XLSM("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",".xlsm"),
    XLSX("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",".xlsx");

    //属性
    private String contentType;
    private String suffix;

    // 构造方法
    private FileType(String contentType,String suffix ){
        this.contentType=contentType;
        this.suffix=suffix;
    }

    /**
     * 传入contentType,获取后缀名
     * @param contentType
     * @return 返回对应的后缀名，没有值就返回null
     */
    public static String getSuffix(String contentType){
        if(StringUtils.isBlank(contentType)){
            return null;
        }
        for(FileType tf:FileType.values()){
            if(contentType.equals(tf.getContentType())){
                return tf.getSuffix();
            }
        }
        return null;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
