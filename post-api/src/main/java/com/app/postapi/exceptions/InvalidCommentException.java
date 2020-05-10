package com.app.postapi.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@RequiredArgsConstructor
public class InvalidCommentException extends RuntimeException {

    private final String commentId;

    @Override
    public String getMessage() {
        return "Provided Comment Id is not Equal with Comment Id in Request Body :" + commentId;
    }

}
