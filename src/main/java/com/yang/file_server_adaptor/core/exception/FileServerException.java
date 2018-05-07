package com.yang.file_server_adaptor.core.exception;

public class FileServerException extends RuntimeException {

    public FileServerException() {
        super();
    }

    public FileServerException(String message) {
        super(message);
    }

    public FileServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileServerException(Throwable cause) {
        super(cause);
    }

    public FileServerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
