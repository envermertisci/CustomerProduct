package com.enoca.springmvc.dao;

import com.enoca.springmvc.entity.Comment;

import java.util.List;
import java.util.Set;

public interface CommentDAO {
    List<Comment> getComments();
    void deleteComment(Integer id);
    void saveComment(Comment comment);
    Comment getComment(Integer id);

    Set<Comment> getCommentsByProduct(Integer id);
}
