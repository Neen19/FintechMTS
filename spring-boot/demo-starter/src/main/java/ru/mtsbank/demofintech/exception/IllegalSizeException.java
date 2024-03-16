package ru.mtsbank.demofintech.exception;

public class IllegalSizeException extends Exception {
    public IllegalSizeException() {
    }

    public IllegalSizeException(String message) {
        super(message);
    }

    public IllegalSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalSizeException(Throwable cause) {
        super(cause);
    }

    public IllegalSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
