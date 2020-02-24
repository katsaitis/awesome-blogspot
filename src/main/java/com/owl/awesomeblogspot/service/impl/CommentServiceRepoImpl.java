package com.owl.awesomeblogspot.service.impl;

import com.owl.awesomeblogspot.domain.entity.Comment;
import com.owl.awesomeblogspot.domain.entity.Post;
import com.owl.awesomeblogspot.domain.repository.CommentRepository;
import com.owl.awesomeblogspot.domain.repository.PostRepository;
import com.owl.awesomeblogspot.service.CommentService;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
public class CommentServiceRepoImpl implements CommentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentServiceRepoImpl.class);

    private final CommentRepository _commentRepository;
    private final PostRepository _postRepository;

    public CommentServiceRepoImpl(@Autowired CommentRepository commentRepository, @Autowired PostRepository postRepository) {
        this._commentRepository = commentRepository;
        this._postRepository = postRepository;
    }

    @Override
    public void saveComment(Comment comment) {
        _commentRepository.saveAndFlush(comment);
    }


    @Override
    public List<Comment> getAllComments() {
        return _commentRepository.findAll();
    }

    @Override
    public Comment findCommentById(Long id) {
        return _commentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Comment> getCommentsByPost(Long postId) {
        return _commentRepository.findByPost(_postRepository.findById(postId).orElseThrow(EntityNotFoundException::new));
    }
}
