package com.hackathon.iplbidding.exception;

import lombok.Getter;

@Getter
public abstract class GeneralException extends Exception {
    private final String errorMessage;

    public GeneralException(final String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}
