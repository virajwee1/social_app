package com.app.postapi.dto.response;

import com.app.postapi.domain.Privacy;
import com.app.postapi.domain.Reaction;
import lombok.Data;

@Data
public class PostDto {

    private String postId;
    private String userProfileId;
    private String content;
    private String updatedDate;

    private Privacy privacy;

    private Reaction reaction;
}
