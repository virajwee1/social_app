package com.app.signupapi.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
@RequiredArgsConstructor
public class UserAlreadyExistsException extends RuntimeException {

    private final String emailAddress;

    @Override
    public String getMessage() {
        return "User already exists with given email :" + emailAddress;
    }
}
