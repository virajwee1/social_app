package com.app.postapi.dto.response;

import lombok.Data;

@Data
public class PostDto {

    private String postId;
    private String userProfileId;
    private String content;
    private String updatedDate;
}
