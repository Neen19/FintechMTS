package ru.mtsbank.demofintech.exception;

public class IllegalInstanceException extends IllegalArgumentException{
    public IllegalInstanceException() {
    }

    public IllegalInstanceException(String s) {
        super(s);
    }

    public IllegalInstanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalInstanceException(Throwable cause) {
        super(cause);
    }
}
