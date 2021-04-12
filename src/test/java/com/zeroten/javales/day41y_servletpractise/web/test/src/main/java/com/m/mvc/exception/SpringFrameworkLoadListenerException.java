package com.m.mvc.exception;

// 抛异常的类
public class SpringFrameworkLoadListenerException extends Exception {
    public SpringFrameworkLoadListenerException() {
    }

    public SpringFrameworkLoadListenerException(String message) {
        super(message);
    }

    public SpringFrameworkLoadListenerException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpringFrameworkLoadListenerException(Throwable cause) {
        super(cause);
    }

    public SpringFrameworkLoadListenerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

