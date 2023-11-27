package com.enoca.springmvc.service;

import com.enoca.springmvc.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getComments();
    void saveComment(Comment comment);
    Comment getComment(Integer id);
    void deleteComment(Integer id);
}
