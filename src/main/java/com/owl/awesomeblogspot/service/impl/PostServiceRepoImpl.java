package com.owl.awesomeblogspot.service.impl;

import com.owl.awesomeblogspot.domain.entity.Post;
import com.owl.awesomeblogspot.domain.repository.PostRepository;
import com.owl.awesomeblogspot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
public class PostServiceRepoImpl implements PostService {

    private final PostRepository _postRepository;

    @Autowired
    public PostServiceRepoImpl(@Autowired PostRepository _postRepository) {
        this._postRepository = _postRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return _postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        // Hurray for functional
        return _postRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void createPost(String title, String body) {
        Post post = new Post(title,body);
        _postRepository.save(post);
    }

    @Override
    public void editPost(Long postId, String title, String body) {
        Post post = _postRepository.findById(postId).orElseThrow(EntityNotFoundException::new);
        post.setTitle(title);
        post.setBody(body);
        _postRepository.save(post);
    }

}
