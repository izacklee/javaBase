package com.zeroten.javales.day08y_reflectexception;

// 自定义异常类
public class AgeInvalidException extends RuntimeException {
    public AgeInvalidException() {
    }

    public AgeInvalidException(String message) {
        super(message);
    }

    public AgeInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public AgeInvalidException(Throwable cause) {
        super(cause);
    }

    public AgeInvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
