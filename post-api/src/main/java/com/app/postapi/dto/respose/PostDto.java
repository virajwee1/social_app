package com.app.postapi.dto.respose;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PostDto {

    private String user_profile_id;
    private String content;
    private String updatedDate;
}
