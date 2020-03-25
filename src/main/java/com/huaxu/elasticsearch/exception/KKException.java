package com.huaxu.elasticsearch.exception;

public class KKException extends RuntimeException {

    public KKException(String message) {
        super(message);
    }

    public KKException(String message, Throwable cause) {
        super(message, cause);
    }

}
