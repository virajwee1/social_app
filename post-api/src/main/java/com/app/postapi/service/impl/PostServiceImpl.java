package com.app.postapi.service.impl;

import com.app.postapi.domain.Post;
import com.app.postapi.dto.request.PostRequest;
import com.app.postapi.dto.response.PostResponse;
import com.app.postapi.exceptions.InvalidPostException;
import com.app.postapi.exceptions.PostNotFoundException;
import com.app.postapi.repository.PostRepository;
import com.app.postapi.service.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * Add Post
     *
     * @param request
     * @return
     */
    @Override
    public PostResponse add(PostRequest request) {
        Post reqPost = this.convertToPostEntity(request);
        return this.convertToPostResponse(postRepository.save(reqPost));
    }

    /**
     * Update Post
     *
     * @param postId
     * @param request
     * @return
     */
    @Override
    public PostResponse update(String postId, PostRequest request) {
        //checking if the postId is equals with request object postId
        if (!postId.equals(request.getPostId())) {
            throw new InvalidPostException(postId);
        }

        //check if post is exists in database
        if (!postRepository.existsById(postId)) {
            throw new PostNotFoundException(postId);
        }
        Post reqPost = this.convertToPostEntity(request);
        return this.convertToPostResponse(postRepository.save(reqPost));
    }

    /**
     * Delete Post
     *
     * @param postId
     */
    @Override
    public void delete(String postId) {
        //check if post is exists in database
        if (!postRepository.existsById(postId)) {
            throw new PostNotFoundException(postId);
        }
        postRepository.deleteById(postId);
    }

    /**
     * Get one post by post id
     *
     * @param postId
     * @return
     */
    @Override
    public PostResponse getPostById(String postId) {
        Post post = postRepository.getOne(postId);
        return this.convertToPostResponse(post);
    }

    /**
     * Get posts by user id
     *
     * @param userProfileId
     * @return
     */
    @Override
    public List<PostResponse> getPostsByUserId(String userProfileId) {
        List<Post> posts = postRepository.getAllByUserProfileIdOrderByUpdatedDate(userProfileId);
        List<PostResponse> postResponses = new ArrayList<>();
        for (Post post : posts) {
            postResponses.add(this.convertToPostResponse(post));
        }
        return postResponses;
    }

    /**
     * Convert PostRequest Object in to Post Object
     *
     * @param request
     * @return
     */
    public Post convertToPostEntity(PostRequest request) {
        Post post = new Post();
        post.setId(request.getPostId());
        post.setUserProfileId(request.getUserProfileId());
        post.setContent(request.getContent());
        post.setPrivacy(request.getPrivacy());
        post.setReaction(request.getReaction());
        return post;
    }


    /**
     * Convert Post object in to PostResponse object
     *
     * @param post
     * @return
     */
    public PostResponse convertToPostResponse(Post post) {
        PostResponse postResponse = new PostResponse();
        postResponse.setPostId(post.getId());
        postResponse.setContent(post.getContent());
        postResponse.setUserProfileId(post.getUserProfileId());
        postResponse.setPrivacy(post.getPrivacy());
        postResponse.setReaction(post.getReaction());
        return postResponse;
    }
}
