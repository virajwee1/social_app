package com.app.postapi.service.impl;

import com.app.postapi.domain.Post;
import com.app.postapi.dto.request.PostRequest;
import com.app.postapi.dto.response.PostDto;
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
    public PostDto add(PostRequest request) {
        Post reqPost = this.convertToPostEntity(request);
        return this.convertToPostDto(postRepository.save(reqPost));
    }

    @Override
    public PostDto update(String postId, PostRequest request) {
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
        if (postRepository.existsById(postId)) {
            throw new PostNotFoundException(postId);
        }
        postRepository.deleteById(postId);
    }

    @Override
    public PostDto getPostById(String postId) {
        Post post = postRepository.getOne(postId);
        return this.convertToPostDto(post);
    }

    @Override
    public List<PostDto> getPostsByUserId(String userProfileId) {
        List<Post> posts = postRepository.getAllByUserProfileIdOrderByUpdatedDate(userProfileId);
        List<PostDto> postDtos = new ArrayList<>();
        for (Post p : posts) {
            postDtos.add(this.convertToPostDto(p));
        }
        return postDtos;
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

    public PostDto convertToPostDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setPostId(post.getId());
        postDto.setContent(post.getContent());
        postDto.setUserProfileId(post.getUserProfileId());
        postDto.setPrivacy(post.getPrivacy());
        postDto.setReaction(post.getReaction());
        return postDto;
    }
}
