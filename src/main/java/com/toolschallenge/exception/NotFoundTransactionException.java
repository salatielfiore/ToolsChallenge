package com.toolschallenge.exception;

public class NotFoundTransactionException extends RuntimeException {

    public NotFoundTransactionException(String message) {
        super(message);
    }
}
