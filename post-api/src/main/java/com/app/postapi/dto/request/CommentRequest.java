package com.app.postapi.dto.request;

import com.app.postapi.domain.Privacy;
import com.app.postapi.domain.Reaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest {

    private String commentId;

    @NotNull(message = "Post Id is required")
    private String postId;

    @NotNull(message = "User Profile Id is required")
    private String userProfileId;

    @NotNull(message = "Comment Text is Required")
    private String commentText;

    private Reaction reaction;

}
