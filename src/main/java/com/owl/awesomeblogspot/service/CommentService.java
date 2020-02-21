package com.owl.awesomeblogspot.service;


import com.owl.awesomeblogspot.domain.entity.Comment;
import com.owl.awesomeblogspot.domain.entity.Post;
import java.util.List;

public interface CommentService {

    public List<Comment> getAllComments();

    public Comment findCommentById(Long id);

    public List<Comment> getCommentsByPost(Post post);
}
