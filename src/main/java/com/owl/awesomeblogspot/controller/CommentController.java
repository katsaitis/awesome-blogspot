package com.owl.awesomeblogspot.controller;


import com.owl.awesomeblogspot.domain.entity.Comment;
import com.owl.awesomeblogspot.service.CommentService;
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
@RequestMapping("/comments")
public class CommentController {

    private final CommentService _commentService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    public CommentController(@Autowired CommentService _commentService) {
        this._commentService = _commentService;
    }

    @GetMapping("")
    @ResponseBody
    public List<Comment> getAllComments() {
        return _commentService.getAllComments();
    }

    @GetMapping("/comment/{id}")
    public Comment getComment(@PathVariable Long id) {
        return _commentService.findCommentById(id);
    }
}
