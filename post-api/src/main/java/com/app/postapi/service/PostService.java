package com.app.postapi.service;

import com.app.postapi.dto.request.PostRequest;
import com.app.postapi.dto.response.PostResponse;

import java.util.List;

public interface PostService {
    /**
     * Add Post
     *
     * @param request PostRequest Object
     * @return PostResponse
     */
    PostResponse add(PostRequest request);

    /**
     * Update Post
     *
     * @param postId  Post Id
     * @param request Post Request
     * @return Post Response
     */
    PostResponse update(String postId, PostRequest request);

    /**
     * Delete Post
     *
     * @param postId Post id
     */
    void delete(String postId);

    /**
     * Get one post by post id
     *
     * @param postId Post Id
     * @return PostResponse
     */
    PostResponse getPostById(String postId);

    /**
     * Get posts by user id
     *
     * @param userProfileId User Id
     * @return List<PostResponse>
     */
    List<PostResponse> getPostsByUserId(String userProfileId);


}
