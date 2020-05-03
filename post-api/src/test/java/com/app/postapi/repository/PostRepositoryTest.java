package com.app.postapi.repository;

import com.app.postapi.domain.Post;
import com.app.postapi.prototype.PostPrototype;
import junit.framework.TestCase;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class PostRepositoryTest extends TestCase {

    @Autowired
    PostRepository postRepository;

    @Test
    public void testGetAllByUserProfileIdOrderByUpdatedDate() {
        postRepository.save(PostPrototype.getPost("content 1"));
        postRepository.save(PostPrototype.getPost("content 2"));
        postRepository.save(PostPrototype.getPost("content 3"));
        List<Post> postList = postRepository.getAllByUserProfileIdOrderByUpdatedDate(PostPrototype.getPost().getUserProfileId());
        Assert.assertThat(postList, Matchers.hasSize(3));

    }

}