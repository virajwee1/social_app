package com.app.postapi.service.impl;

import com.app.postapi.domain.Post;
import com.app.postapi.dto.response.PostDto;
import com.app.postapi.prototype.PostPrototype;
import com.app.postapi.repository.PostRepository;
import com.app.postapi.service.PostConverter;
import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceImplTest extends TestCase {

    @Mock
    private PostRepository postRepository;

    @Mock
    private PostConverter postConverter;

    @InjectMocks
    private PostServiceImpl postService;

    @Test
    public void testAdd() {
        when(postRepository.save(any())).thenReturn(PostPrototype.getPost());
        Post post = postService.add(PostPrototype.getPostRequest());
        Assert.assertNotNull(post);
    }

    public void testUpdate() {
    }

    @Test
    public void testDelete() {
        when(postRepository.save(any())).thenReturn(PostPrototype.getPost());
        postService.delete(PostPrototype.getPost().getId());
//        Assert.assertThat(postService.getPostById(PostPrototype.getPost().getId()),);
    }


    @Test
    public void testGetPostById() {
        when(postRepository.findById(eq("post-id"))).thenReturn(java.util.Optional.of(PostPrototype.getPost()));
        PostDto postDto = postService.getPostById("post-id");
        assertNotNull(postDto);
        assertEquals(postDto.getPostId(),"post-id");
    }

    public void testGetPostsByUser() {
    }
}