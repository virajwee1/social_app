package com.app.postapi.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@RequiredArgsConstructor
public class PostNotFoundException extends RuntimeException {

    private final String postId;

    @Override
    public String getMessage() {
        return "Post not found for Provided Post id :" + postId;
    }

}
