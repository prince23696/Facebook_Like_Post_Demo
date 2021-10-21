package com.FackbookPostDemo.Service;

import com.FackbookPostDemo.Entity.Comment;

import java.util.List;

public interface CommentService {


    public Comment saveComment(Comment comment);

    public List<Comment> getAllComments();

    public Comment getComment(int id);

    public String deleteComment(int id);

}
