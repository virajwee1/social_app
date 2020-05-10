package com.app.postapi.repository;

import com.app.postapi.domain.Comment;
import com.app.postapi.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, String> {

    List<Comment> getAllByPostOrderByCreatedDateDesc(Post post);
}
