package com.owl.awesomeblogspot.controller;

import com.owl.awesomeblogspot.domain.entity.Post;
import com.owl.awesomeblogspot.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService _postService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    public PostController(@Autowired PostService _postService) {
        this._postService = _postService;
    }

    @GetMapping("")
    @ResponseBody
    public List<Post> getAllPosts() {
        return _postService.getAllPosts();
    }

    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable Long id) {
        return _postService.findById(id);
    }
}
