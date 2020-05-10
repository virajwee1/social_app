package com.app.postapi.controller;

import com.app.postapi.prototype.PostPrototype;
import com.app.postapi.repository.PostRepository;
import com.app.postapi.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


class PostControllerTest {

    MockMvc mockMvc;
    PostService postService;
    PostRepository postRepository;
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        postService = mock(PostService.class);
        postRepository = mock(PostRepository.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new PostController(postService)).build();
        objectMapper = new ObjectMapper();
    }


    @Test
    void addPost() throws Exception {
        when(postService.add(any())).thenReturn(PostPrototype.getPostResponse());
        mockMvc.perform(post("/v1/post/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(PostPrototype.getPostRequest())))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    void getPost() {

    }

    @Test
    void getPostByUserProfile() {
    }

    @Test
    void updatePost() throws Exception {
        when(postService.update(anyString(), any())).thenReturn(PostPrototype.getPostResponseWithId());
        mockMvc.perform(put("/v1/post/post-id")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(PostPrototype.getPostRequest())))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void deletePost() throws Exception {
        when(postService.getPostById(eq("post-id")))
                .thenReturn(PostPrototype.getPostResponseWithId());
        mockMvc.perform(delete("/v1/post/{post-id}", "post-id")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}