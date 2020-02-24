package com.owl.awesomeblogspot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.owl.awesomeblogspot.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final PostService _postService;
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    public AdminController(@Autowired PostService postService) {
        this._postService = postService;
    }

    @GetMapping("/login")
    public String authenticate() {
        return "login";
    }

    @GetMapping("/index")
    public String getAdminIndex() {
        return "admin";
    }

    @PostMapping("/post")
    public String createPost(@RequestParam(value = "title") String title, @RequestParam(value = "body") String body) {
        _postService.createPost(title, body);
        return "redirect:/";
    }

}
