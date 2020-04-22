package com.app.postapi.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PostRequest {

    private String postId;

    @NotNull(message = "User Profile Id is required")
    private String userProfileId;

    @NotNull(message = "Content is Required")
    private String content;


}
