package com.app.postapi.repository;


import com.app.postapi.domain.Post;
import com.app.postapi.prototype.PostPrototype;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PostRepositoryTest {

    @Mock
    PostRepository postRepository;

    @Test
    public void testGetAllByUserProfileIdOrderByUpdatedDate() {
        Mockito.when(postRepository
                .getAllByUserProfileIdOrderByUpdatedDate(PostPrototype.getPost().getUserProfileId()))
                .thenReturn(PostPrototype.getPostList());
        List<Post> postList = postRepository.getAllByUserProfileIdOrderByUpdatedDate("aa-bb");
        Assert.assertNotNull(postList);
        Assert.assertThat(postList, Matchers.hasSize(5));
    }

}