package com.app.postapi.controller;

import com.app.postapi.dto.request.CommentRequest;
import com.app.postapi.dto.response.CommentResponse;
import com.app.postapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * Add Comment
     *
     * @param commentRequest
     * @return
     */
    @PostMapping
    public ResponseEntity<CommentResponse> addComment(@RequestBody CommentRequest commentRequest) {
        commentService.add(commentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Get Comment by comment id
     *
     * @param commentId
     * @return
     */
    @GetMapping(value = "{commentId}")
    public ResponseEntity<CommentResponse> getComment(@PathVariable("commentId") String commentId) {
        return ResponseEntity.ok(commentService.getCommentById(commentId));
    }

    /**
     * Get Comment List by post id
     *
     * @param postId
     * @return
     */
    @GetMapping(value = "/by-post/{postId}")
    public ResponseEntity<List<CommentResponse>> getCommentByPostId(@PathVariable("postId") String postId) {
        return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
    }

    /**
     * Update Comment
     *
     * @param commentId
     * @param commentRequest
     * @return
     */
    public ResponseEntity<CommentResponse> updateComment(@PathVariable("commentId") String commentId,
                                                         @RequestBody CommentRequest commentRequest) {
        commentService.update(commentId, commentRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * Delete Comment
     *
     * @param commentId
     * @return
     */
    public ResponseEntity<Void> deleteComment(@PathVariable("commentId") String commentId) {
        commentService.delete(commentId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
