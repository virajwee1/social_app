package com.app.postapi.service;

import com.app.postapi.dto.request.CommentRequest;
import com.app.postapi.dto.response.CommentResponse;

import java.util.List;

public interface CommentService {
    /**
     * Add Comment
     * @param request
     * @return
     */
    CommentResponse add(CommentRequest request);

    /**
     * Update Comment
     * @param commentId
     * @param request
     * @return
     */
    CommentResponse update(String commentId, CommentRequest request);

    /**
     * Delete Comment
     * @param commentId
     */
    void delete(String commentId);

    /**
     * Get one comment by comment id
     * @param commentId
     * @return
     */
    CommentResponse getCommentById(String commentId);

    /**
     * Get comments for a post
     * @param postId
     * @return
     */
    List<CommentResponse> getCommentsByPostId(String postId);
}
