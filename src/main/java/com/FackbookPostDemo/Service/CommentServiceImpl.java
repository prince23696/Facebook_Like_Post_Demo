package com.FackbookPostDemo.Service;

import com.FackbookPostDemo.Entity.Comment;
import com.FackbookPostDemo.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getComment(int id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public String deleteComment(int id) {
        commentRepository.deleteById(id);
        return "Comment Deleted";
    }
}
