package com.app.postapi.controller;

import com.app.postapi.dto.request.PostRequest;
import com.app.postapi.dto.response.PostResponse;
import com.app.postapi.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/post")
public class PostController {


    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Void> addPost(@RequestBody PostRequest postRequest) {
        postService.add(postRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "{postId}")
    public ResponseEntity<PostResponse> getPost(@PathVariable("postId") String postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @GetMapping(value = "/user-wall/{userProfileId}")
    public ResponseEntity<List<PostResponse>> getPostByUserProfile(@PathVariable("userProfileId") String userProfileId) {
        return ResponseEntity.ok(postService.getPostsByUserId(userProfileId));
    }

    @PutMapping(value = "{postId}")
    public ResponseEntity<Void> updatePost(@PathVariable("postId") String postId,
                                           @RequestBody PostRequest postRequest) {
        postService.update(postId, postRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(value = "{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable("postId") String postId) {
        postService.delete(postId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
