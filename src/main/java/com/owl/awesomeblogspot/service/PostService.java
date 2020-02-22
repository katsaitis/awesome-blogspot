package com.owl.awesomeblogspot.service;

import com.owl.awesomeblogspot.domain.entity.Post;
import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    Post findById(Long id);

    void createPost(String title, String body);

    void editPost(Long postId, String title, String body);
}
