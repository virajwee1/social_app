package com.app.postapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {

    private String commentId;
    private String postId;
    private String userProfileId;
    private String commentText;
    private String updatedDate;

}
