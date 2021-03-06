package com.app.postapi.service.impl;

import com.app.postapi.dto.response.PostResponse;
import com.app.postapi.prototype.PostPrototype;
import com.app.postapi.repository.PostRepository;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceImplTest extends TestCase {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostServiceImpl postService;

    @Test
    public void testAdd() {
        when(postRepository.save(any())).thenReturn(PostPrototype.getPost());
        PostResponse postResponse = postService.add(PostPrototype.getPostRequest());
        Assert.assertNotNull(postResponse);
    }

    @Test
    public void testUpdate() {
        when(postRepository.save(any())).thenReturn(PostPrototype.getPost());
        when(postRepository.existsById(any())).thenReturn(Boolean.TRUE);
        PostResponse postResponse = postService.update("post-id", PostPrototype.getPostRequestWithId());
        Assert.assertNotNull(postResponse);
    }

    @Test
    public void testDelete() {
        String postId = "post-id";
        postService.delete(postId);
        verify(postRepository, times(1)).deleteById((eq(postId)));
    }


    @Test
    public void testGetPostById() {
        when(postRepository.getOne(eq("post-id")))
                .thenReturn(PostPrototype.getPostWithId());
        PostResponse postResponse = postService.getPostById("post-id");
        assertNotNull(postResponse);
        assertEquals(postResponse.getPostId(), "post-id");
    }

    public void testGetPostsByUserId() {
        when(postRepository.getAllByUserProfileIdOrderByUpdatedDate(eq("aa-bb")))
                .thenReturn(PostPrototype.getPostList());
    }
}