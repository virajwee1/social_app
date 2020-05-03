package com.app.postapi.prototype;

import com.app.postapi.domain.Post;
import com.app.postapi.domain.Privacy;
import com.app.postapi.domain.Reaction;

import java.util.ArrayList;
import java.util.List;

public class PostPrototype {

    public static Post getPost() {
        Post post = new Post();
        post.setUserProfileId("aa-bb");
        post.setContent("this is test content");
        return post;
    }

    public static Post getPost(String content) {
        Post post = new Post();
        post.setUserProfileId("aa-bb");
        post.setContent(content);
        post.setPrivacy(Privacy.PUBLIC);
        post.setReaction(Reaction.EMPTY_REACTION);
        return post;
    }

    public static List<Post> getPostList(){
        List<Post> postList = new ArrayList<>();
        postList.add(getPost("This is Test Content 1"));
        postList.add(getPost("This is Test Content 2"));
        postList.add(getPost("This is Test Content 3"));
        postList.add(getPost("This is Test Content 4"));
        postList.add(getPost("This is Test Content 5"));
        return postList;
    }
}
