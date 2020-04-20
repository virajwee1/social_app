package com.app.postapi.service.impl;

import com.app.postapi.domain.Post;
import com.app.postapi.dto.request.PostRequest;
import com.app.postapi.dto.respose.PostDto;
import com.app.postapi.repository.PostRepository;
import com.app.postapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public void add(PostRequest request) {
        postRepository.save(this.convertToPostEntity(request));
    }

    @Override
    public void update(PostRequest request) {
        postRepository.save(this.convertToPostEntity(request));
    }

    @Override
    public void delete(String post_id) {
        postRepository.deleteById(post_id);
    }

    @Override
    public PostDto getPostById(String post_id) {
        return null;
    }

    @Override
    public List<PostDto> getPosts() {
        return null;
    }

    @Override
    public List<PostDto> getPostsByUser(String userProfileId) {
        return null;
    }


    private Post convertToPostEntity(PostRequest request) {
        Post post = new Post();
        post.setUser_profile_id(request.getUser_profile_id());
        post.setContent(request.getContent());
        return post;
    }

}
