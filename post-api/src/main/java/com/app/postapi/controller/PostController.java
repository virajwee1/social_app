package com.app.postapi.controller;

import com.app.postapi.dto.request.PostRequest;
import com.app.postapi.dto.respose.PostDto;
import com.app.postapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/post")
public class PostController  {

    @Autowired
    private PostService postService;


    @PostMapping
    public ResponseEntity<Void> addPost(@RequestBody PostRequest postRequest) {
        postService.add(postRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "{postid}")
    public ResponseEntity<PostDto> getPost(@PathVariable("postid") String postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @PutMapping
    public ResponseEntity<Void> updatePost(@RequestBody PostRequest postRequest){
        postService.update(postRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(value = "{postid}")
    public ResponseEntity<Void> deletePost(@PathVariable("postid") String postId){
        postService.delete(postId);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
