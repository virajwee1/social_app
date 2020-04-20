package com.app.postapi.service;

import com.app.postapi.dto.request.PostRequest;
import com.app.postapi.dto.respose.PostDto;

import java.util.List;

public interface PostService {

    void add(PostRequest request);

    void update(PostRequest request);

    void delete(String post_id);

    PostDto getPostById(String post_id);

    List<PostDto> getPosts();

    List<PostDto> getPostsByUser(String userProfileId);



}
