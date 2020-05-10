package com.app.postapi.dto.response;

import com.app.postapi.domain.Privacy;
import com.app.postapi.domain.Reaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

    private String postId;
    private String userProfileId;
    private String content;
    private Date updatedDate;
    private Privacy privacy;
    private Reaction reaction;
}
