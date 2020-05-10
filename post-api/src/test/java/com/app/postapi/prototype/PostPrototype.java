package com.app.postapi.prototype;

import com.app.postapi.domain.Post;
import com.app.postapi.domain.Privacy;
import com.app.postapi.domain.Reaction;
import com.app.postapi.dto.request.PostRequest;
import com.app.postapi.dto.response.PostResponse;

import java.util.ArrayList;
import java.util.List;

public class PostPrototype {

    public static Post getPost() {
        Post post = new Post();
        post.setUserProfileId("aa-bb");
        post.setContent("Test Content Post");
        post.setPrivacy(Privacy.PUBLIC);
        post.setReaction(Reaction.EMPTY_REACTION);
        return post;
    }

    public static Post getPostWithId() {
        Post post = new Post();
        post.setId("post-id");
        post.setUserProfileId("aa-bb");
        post.setContent("Test Content Post");
        post.setPrivacy(Privacy.PUBLIC);
        post.setReaction(Reaction.EMPTY_REACTION);
        return post;
    }

    public static PostRequest getPostRequest() {
        PostRequest postRequest = new PostRequest();
        postRequest.setUserProfileId("aa-bb");
        postRequest.setContent("Test Content Post Request");
        postRequest.setPrivacy(Privacy.PUBLIC);
        postRequest.setReaction(Reaction.EMPTY_REACTION);

        return postRequest;
    }

    public static PostRequest getPostRequestWithId() {
        PostRequest postRequest = new PostRequest();
        postRequest.setPostId("post-id");
        postRequest.setUserProfileId("aa-bb");
        postRequest.setContent("Test Content Post Request");
        postRequest.setPrivacy(Privacy.PUBLIC);
        postRequest.setReaction(Reaction.EMPTY_REACTION);
        return postRequest;
    }

    public static PostResponse getPostResponse() {
        PostResponse postResponse = new PostResponse();
        postResponse.setUserProfileId("aa-bb");
        postResponse.setContent("Test Content Post Dto");
        postResponse.setPrivacy(Privacy.PUBLIC);
        postResponse.setReaction(Reaction.EMPTY_REACTION);
        return postResponse;
    }

    public static PostResponse getPostResponseWithId() {
        PostResponse postResponse = new PostResponse();
        postResponse.setPostId("post-id");
        postResponse.setUserProfileId("aa-bb");
        postResponse.setContent("Test Content Post Dto");
        postResponse.setPrivacy(Privacy.PUBLIC);
        postResponse.setReaction(Reaction.EMPTY_REACTION);
        return postResponse;
    }

    public static Post getPost(String content) {
        Post post = new Post();
        post.setUserProfileId("aa-bb");
        post.setContent(content);
        post.setPrivacy(Privacy.PUBLIC);
        post.setReaction(Reaction.EMPTY_REACTION);
        return post;
    }

    public static List<Post> getPostList() {
        List<Post> postList = new ArrayList<>();
        postList.add(getPost("This is Test Content 1"));
        postList.add(getPost("This is Test Content 2"));
        postList.add(getPost("This is Test Content 3"));
        postList.add(getPost("This is Test Content 4"));
        postList.add(getPost("This is Test Content 5"));
        return postList;
    }
}
