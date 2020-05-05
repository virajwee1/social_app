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
        PostRequest postRequest = PostRequest.builder()
                .userProfileId("aa-bb")
                .content("Test Content Post Request")
                .privacy(Privacy.PUBLIC)
                .reaction(Reaction.EMPTY_REACTION)
                .build();
        return postRequest;
    }

    public static PostRequest getPostRequestWithId() {
        PostRequest postRequest = PostRequest.builder()
                .postId("post-id")
                .userProfileId("aa-bb")
                .content("Test Content Post Request")
                .privacy(Privacy.PUBLIC)
                .reaction(Reaction.EMPTY_REACTION)
                .build();
        return postRequest;
    }

    public static PostResponse getPostDto() {
        PostResponse postResponse = PostResponse.builder()
                .userProfileId("aa-bb")
                .content("Test Content Post Dto")
                .privacy(Privacy.PUBLIC)
                .reaction(Reaction.EMPTY_REACTION)
                .build();
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
