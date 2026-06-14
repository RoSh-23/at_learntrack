package com.airtribe.learntrack.exception;

public class InvalidEmailException extends RuntimeException {
    final String invalidEmail;

    public InvalidEmailException(String message, String invalidEmail) {
        super(message);
        this.invalidEmail = invalidEmail;
    }

    // for logging purposes
    public String getInvalidEmail() {
        return invalidEmail;
    }
}
