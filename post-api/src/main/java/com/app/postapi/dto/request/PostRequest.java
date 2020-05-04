package com.app.postapi.dto.request;

import com.app.postapi.domain.Privacy;
import com.app.postapi.domain.Reaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {

    private String postId;

    @NotNull(message = "User Profile Id is required")
    private String userProfileId;

    @NotNull(message = "Content is Required")
    private String content;

    private Privacy privacy;

    private Reaction reaction;

}
