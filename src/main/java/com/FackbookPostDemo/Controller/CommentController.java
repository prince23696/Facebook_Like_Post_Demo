package com.FackbookPostDemo.Controller;

import com.FackbookPostDemo.Entity.Comment;
import com.FackbookPostDemo.Repository.PostRepository;
import com.FackbookPostDemo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CommentController {

    @Autowired
    CommentService commentService;
    @Autowired
    PostRepository postRepository;

    @PostMapping("/saveComment/{id}")
    public Comment saveComment(@PathVariable int id, @RequestBody Comment comment) {
        comment.setPost(postRepository.findById(id).get());
        return commentService.saveComment(comment);
    }

    @GetMapping("/getAllComments")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/getComment/{id}")
    public Comment getComment(@PathVariable int id) {
        return commentService.getComment(id);
    }

    @DeleteMapping("/deleteComment/{id}")
    public String deleteComment(@PathVariable int id) {
        return commentService.deleteComment(id);
    }
}
