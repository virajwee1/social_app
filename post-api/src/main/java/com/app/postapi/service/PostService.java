package com.app.postapi.service;

import com.app.postapi.dto.request.PostRequest;
import com.app.postapi.dto.response.PostResponse;

import java.util.List;

public interface PostService {
    /**
     * Add post
     *
     * @param request
     * @return
     */
    PostResponse add(PostRequest request);

    /**
     * Update Post
     *
     * @param postId
     * @param request
     * @return
     */
    PostResponse update(String postId, PostRequest request);

    /**
     * Delete Post
     *
     * @param postId
     */
    void delete(String postId);

    /**
     * Get one post by post id
     *
     * @param postId
     * @return
     */
    PostResponse getPostById(String postId);

    /**
     * Get posts by user id
     *
     * @param userProfileId
     * @return
     */
    List<PostResponse> getPostsByUserId(String userProfileId);


}
