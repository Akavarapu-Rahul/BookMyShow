package com.scaler.BookMyShow.exception;

public class ShowSeatAlreadyBookedException extends Exception{
    public ShowSeatAlreadyBookedException() {
    }

    public ShowSeatAlreadyBookedException(String message) {
        super(message);
    }

    public ShowSeatAlreadyBookedException(String message, Throwable cause) {
        super(message, cause);
    }
}
