package com.app.postapi.service.impl;

import com.app.postapi.domain.Post;
import com.app.postapi.dto.request.PostRequest;
import com.app.postapi.dto.response.PostResponse;
import com.app.postapi.exceptions.InvalidPostException;
import com.app.postapi.exceptions.PostNotFoundException;
import com.app.postapi.repository.PostRepository;
import com.app.postapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;


    @Override
    public PostResponse add(PostRequest request) {
        Post reqPost = this.convertToPostEntity(request);
        return this.convertToPostDto(postRepository.save(reqPost));
    }

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
        return this.convertToPostDto(postRepository.save(reqPost));
    }

    @Override
    public void delete(String postId) {
        //check if post is exists in database
        if (!postRepository.existsById(postId)) {
            throw new PostNotFoundException(postId);
        }
        postRepository.deleteById(postId);
    }

    @Override
    public PostResponse getPostById(String postId) {
        Post post = postRepository.getOne(postId);
        return this.convertToPostDto(post);
    }

    @Override
    public List<PostResponse> getPostsByUserId(String userProfileId) {
        List<Post> posts = postRepository.getAllByUserProfileIdOrderByUpdatedDate(userProfileId);
        List<PostResponse> postResponses = new ArrayList<>();
        for (Post post : posts) {
            postResponses.add(this.convertToPostDto(post));
        }
        return postResponses;
    }

    public Post convertToPostEntity(PostRequest request) {
        Post post = new Post();
        post.setId(request.getPostId());
        post.setUserProfileId(request.getUserProfileId());
        post.setContent(request.getContent());
        post.setPrivacy(request.getPrivacy());
        post.setReaction(request.getReaction());
        return post;
    }

    public PostResponse convertToPostDto(Post post) {
        PostResponse postResponse = new PostResponse();
        postResponse.setPostId(post.getId());
        postResponse.setContent(post.getContent());
        postResponse.setUserProfileId(post.getUserProfileId());
        postResponse.setPrivacy(post.getPrivacy());
        postResponse.setReaction(post.getReaction());
        return postResponse;
    }
}
