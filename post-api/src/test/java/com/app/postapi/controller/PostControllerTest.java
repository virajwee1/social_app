package com.app.postapi.controller;


import com.app.postapi.prototype.PostPrototype;
import com.app.postapi.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(MockitoJUnitRunner.class)
public class PostControllerTest {

    @Mock
    PostService postService;
    MockMvc mockMvc;
    ObjectMapper objectMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new PostController(postService)).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void addPost() throws Exception {
        when(postService.add(any())).thenReturn(PostPrototype.getPostResponse());
        mockMvc.perform(post("/v1/post/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(PostPrototype.getPostRequest())))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    public void getPost() throws Exception {
        when(postService.getPostById(anyString())).thenReturn(PostPrototype.getPostResponseWithId());
        mockMvc.perform(get("/v1/post/post-id")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(PostPrototype.getPost("post-id"))))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getPostByUserProfile() throws Exception {
        mockMvc.perform(get("/v1/post/user-wall/user-id")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(PostPrototype.getPostResponseList())))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updatePost() throws Exception {
        when(postService.update(anyString(), any())).thenReturn(PostPrototype.getPostResponseWithId());
        mockMvc.perform(put("/v1/post/post-id")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(PostPrototype.getPostRequest())))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void deletePost() throws Exception {
        mockMvc.perform(delete("/v1/post/{post-id}", "post-id")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}