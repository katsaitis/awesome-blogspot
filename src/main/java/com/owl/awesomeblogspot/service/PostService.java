package com.owl.awesomeblogspot.service;

import com.owl.awesomeblogspot.domain.entity.Post;
import java.util.List;

public interface PostService {

    public List<Post> getAllPosts();

    public Post findById(Long id);
}
