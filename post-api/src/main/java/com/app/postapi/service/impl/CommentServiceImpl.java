package com.app.postapi.service.impl;

import com.app.postapi.domain.Comment;
import com.app.postapi.dto.request.CommentRequest;
import com.app.postapi.dto.response.CommentResponse;
import com.app.postapi.exceptions.CommentNotFoundException;
import com.app.postapi.exceptions.InvalidCommentException;
import com.app.postapi.repository.CommentRepository;
import com.app.postapi.repository.PostRepository;
import com.app.postapi.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    /**
     * Add Comment
     *
     * @param request CommentRequest Object
     * @return CommentResponse Object
     */
    @Override
    public CommentResponse add(CommentRequest request) {
        Comment comment = this.convertToCommentEntity(request);
        return this.convertToCommentResponse(commentRepository.save(comment));
    }

    /**
     * Update Comment
     *
     * @param commentId commentId String
     * @param request   CommentRequest Object
     * @return CommentResponse Object
     */
    @Override
    public CommentResponse update(String commentId, CommentRequest request) {
        //checking if the commentId is equals with request object commentId
        if (!commentId.equals(request.getCommentId())) {
            throw new InvalidCommentException(commentId);
        }

        //check if post is exists in database
        if (!commentRepository.existsById(commentId)) {
            throw new CommentNotFoundException(commentId);
        }
        Comment oldComment = commentRepository.getOne(request.getCommentId());
        oldComment.setCommentText(request.getCommentText());
        return this.convertToCommentResponse(commentRepository.save(oldComment));
    }

    /**
     * Delete Comment
     *
     * @param commentId commentId String
     */
    @Override
    public void delete(String commentId) {
        //check if the comment is exists in the database
        if (!commentRepository.existsById(commentId)) {
            throw new CommentNotFoundException(commentId);
        }
        commentRepository.deleteById(commentId);
    }

    /**
     * Get one comment by comment id
     *
     * @param commentId commentId String
     * @return CommentResponse Object
     */
    @Override
    public CommentResponse getCommentById(String commentId) {
        Comment comment = commentRepository.getOne(commentId);
        return this.convertToCommentResponse(comment);
    }

    /**
     * Get comments for a post
     *
     * @param postId postId String
     * @return List<CommentResponse>
     */
    @Override
    public List<CommentResponse> getCommentsByPostId(String postId) {
        List<Comment> comments = commentRepository.getAllByPostOrderByCreatedDateDesc(postRepository.getOne(postId));
        List<CommentResponse> commentResponses = new ArrayList<>();
        for (Comment comment : comments) {
            commentResponses.add(this.convertToCommentResponse(comment));
        }
        return commentResponses;
    }

    /**
     * Convert CommentRequest object to Comment object
     *
     * @param commentRequest CommentRequest Object
     * @return Comment Object
     */
    private Comment convertToCommentEntity(CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setId(commentRequest.getCommentId());
        comment.setUserProfileId(commentRequest.getUserProfileId());
        comment.setCommentText(commentRequest.getCommentText());
        comment.setPost(postRepository.getOne(commentRequest.getPostId()));
        return comment;
    }

    /**
     * Convert Comment object to CommentResponse object
     *
     * @param comment Comment Object
     * @return CommentResponse object
     */
    private CommentResponse convertToCommentResponse(Comment comment) {
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setCommentId(comment.getId());
        commentResponse.setCommentText(comment.getCommentText());
        commentResponse.setUserProfileId(comment.getUserProfileId());
        commentResponse.setPostId(comment.getPost().getId());
        commentResponse.setUpdatedDate(comment.getUpdatedDate());
        return commentResponse;

    }
}
