package com.practice.systemdesign.parkinglot.exception;

public class UnableToBookTicketException extends RuntimeException {
    public UnableToBookTicketException(String message) {
        super(message);
    }
}
