package com.app.postapi.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@RequiredArgsConstructor
public class CommentNotFoundException extends RuntimeException {

    private final String commentId;

    @Override
    public String getMessage() {
        return "Comment not found for Provided Comment id :" + commentId;
    }

}
