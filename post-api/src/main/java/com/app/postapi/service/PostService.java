package com.app.postapi.service;

import com.app.postapi.dto.request.PostRequest;
import com.app.postapi.dto.response.PostResponse;

import java.util.List;

public interface PostService {

    PostResponse add(PostRequest request);

    PostResponse update(String postId, PostRequest request);

    void delete(String postId);

    PostResponse getPostById(String postId);

    List<PostResponse> getPostsByUserId(String userProfileId);


}
