package com.app.postapi.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class PostRequest {

    @NotNull(message = "User Profile Id is required")
    private String user_profile_id;

    @NotNull(message = "Content is Required")
    private String content;


}
