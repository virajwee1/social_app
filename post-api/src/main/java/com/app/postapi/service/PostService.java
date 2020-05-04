package com.app.postapi.service;

import com.app.postapi.dto.request.PostRequest;
import com.app.postapi.dto.response.PostDto;

import java.util.List;

public interface PostService {

    PostDto add(PostRequest request);

    PostDto update(String postId, PostRequest request);

    void delete(String postId);

    PostDto getPostById(String postId);

    List<PostDto> getPostsByUserId(String userProfileId);


}
