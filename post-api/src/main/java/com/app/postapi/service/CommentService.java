package com.app.postapi.service;

import com.app.postapi.dto.request.CommentRequest;
import com.app.postapi.dto.response.CommentResponse;

import java.util.List;

public interface CommentService {
    /**
     * Add Comment
     *
     * @param request CommentRequest Object
     * @return CommentResponse Object
     */
    CommentResponse add(CommentRequest request);

    /**
     * Update Comment
     *
     * @param commentId commentId String
     * @param request   CommentRequest Object
     * @return CommentResponse Object
     */
    CommentResponse update(String commentId, CommentRequest request);

    /**
     * Delete Comment
     *
     * @param commentId commentId String
     */
    void delete(String commentId);

    /**
     * Get one comment by comment id
     *
     * @param commentId commentId String
     * @return CommentResponse Object
     */
    CommentResponse getCommentById(String commentId);

    /**
     * Get comments for a post
     *
     * @param postId postId String
     * @return List<CommentResponse>
     */
    List<CommentResponse> getCommentsByPostId(String postId);
}
