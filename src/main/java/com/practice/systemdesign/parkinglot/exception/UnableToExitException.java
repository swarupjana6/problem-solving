package com.practice.systemdesign.parkinglot.exception;

public class UnableToExitException extends RuntimeException {
    public UnableToExitException(String message) {
        super(message);
    }
}
