package com.app.postapi.service;

import com.app.postapi.domain.Post;
import com.app.postapi.dto.request.PostRequest;
import com.app.postapi.dto.response.PostDto;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {

    public Post convertToPostEntity(PostRequest request) {
        Post post = new Post();
        post.setId(request.getPostId());
        post.setUserProfileId(request.getUserProfileId());
        post.setContent(request.getContent());

        return post;
    }

    public PostDto convertToPostDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setContent(post.getContent());
        postDto.setUpdatedDate(post.getUpdatedDate().toString());
        postDto.setUserProfileId(post.getUserProfileId());
        return postDto;
    }
}
