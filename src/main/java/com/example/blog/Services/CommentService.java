package com.example.blog.Services;


import com.example.blog.DTO.Comment.CommentCommentDTO;
import com.example.blog.DTO.Comment.PostCommentDTO;
import com.example.blog.Repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    public void savePostComment(PostCommentDTO comment) {
        commentRepository.save(comment);
    }

    public void saveCommentComment(CommentCommentDTO comment) {
        commentRepository.save(comment);
    }

    public void removeComment(Long id){
        commentRepository.deleteById(id);
    }
}
