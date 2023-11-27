package com.enoca.springmvc.service;

import com.enoca.springmvc.dao.CommentDAO;
import com.enoca.springmvc.dao.CustomerDAO;
import com.enoca.springmvc.entity.Comment;
import com.enoca.springmvc.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("commentService")
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentDAO commentDAO;

    @Override
    public List<Comment> getComments() {
        return commentDAO.getComments();
    }

    @Override
    public void saveComment(final Comment comment) {
        commentDAO.saveComment(comment);
    }
    @Override

    public Comment getComment(final Integer id) {
        return commentDAO.getComment(id);
    }


    @Override
    public void deleteComment(final Integer id) {
        commentDAO.deleteComment(id);
    }
}
