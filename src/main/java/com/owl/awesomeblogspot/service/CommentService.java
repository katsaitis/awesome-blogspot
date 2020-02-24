package com.owl.awesomeblogspot.service;


import com.owl.awesomeblogspot.domain.entity.Comment;
import com.owl.awesomeblogspot.domain.entity.Post;
import java.util.List;

public interface CommentService {

    void saveComment(Comment comment);

    List<Comment> getAllComments();

    Comment findCommentById(Long id);

    List<Comment> getCommentsByPost(Long postId);
}
