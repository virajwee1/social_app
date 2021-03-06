package com.app.postapi.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@RequiredArgsConstructor
public class InvalidPostException extends RuntimeException {

    private final String postId;

    @Override
    public String getMessage() {
        return "Provided Post Id is not Equal with Post Id in Request Body :" + postId;
    }

}
