package com.owl.awesomeblogspot.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.owl.awesomeblogspot.domain.entity.Comment;
import com.owl.awesomeblogspot.service.CommentService;
import com.owl.awesomeblogspot.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final CommentService _commentService;
    private final PostService _postService;



    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    private final ObjectMapper _mapper;

    public CommentController(@Autowired CommentService _commentService,
                             @Autowired PostService _postService,
                             @Autowired ObjectMapper mapper) {
        this._commentService = _commentService;
        this._postService = _postService;
        this._mapper = mapper;
    }

    @GetMapping("")
    @ResponseBody
    public List<Comment> getAllComments() {
        return _commentService.getAllComments();
    }

    @GetMapping("/{postId}")
    @ResponseBody
    public List<Comment> getCommentsOfPost(@PathVariable Long postId) {
        return  _commentService.getCommentsByPost(postId);
    }

    @GetMapping("/comment/{id}")
    public Comment getComment(@PathVariable Long id) {
        return _commentService.findCommentById(id);
    }

    @PostMapping("/comment")
    @ResponseBody
    public String postComment(@RequestBody String data) throws JsonProcessingException {
        ObjectNode commentNode = (ObjectNode) _mapper.readTree(data);

        Comment comment = new Comment();
        if (commentNode.has("id")) {
            comment.setPost(_postService.findById(commentNode.get("id").asLong()).orElseThrow(EntityNotFoundException::new));
        }
        comment.setBody(commentNode.get("title").asText());
        _commentService.saveComment(comment);
        return "Successfully saved comment!";
    }
}
