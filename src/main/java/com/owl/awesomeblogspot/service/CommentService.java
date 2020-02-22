package com.owl.awesomeblogspot.service;


import com.owl.awesomeblogspot.domain.entity.Comment;
import com.owl.awesomeblogspot.domain.entity.Post;
import java.util.List;

public interface CommentService {

    List<Comment> getAllComments();

    Comment findCommentById(Long id);

    List<Comment> getCommentsByPost(Post post);
}
