package com.example.blog.Controllers;

import com.example.blog.DTO.Comment.CommentCommentDTO;
import com.example.blog.DTO.Comment.CommentDTO;
import com.example.blog.DTO.Comment.PostCommentDTO;
import com.example.blog.Entities.Post;
import com.example.blog.Repositories.CommentRepository;
import com.example.blog.Repositories.PostRepository;
import com.example.blog.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/comment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;


    @PostMapping
    public void commentPost(@RequestBody PostCommentDTO comment){
        commentService.savePostComment(comment);
    }

    @PostMapping
    public void commentComment(@RequestBody CommentCommentDTO comment){
        commentService.saveCommentComment(comment);
    }

    @PutMapping()
    public void updateComment(@RequestBody CommentDTO _comment) {
        Optional<CommentDTO> optionalComment = commentRepository.findById(_comment.getId());

        if(optionalComment.isEmpty()){
            return;
        }

        CommentDTO comment = optionalComment.get();
        comment.setText(_comment.getText());

        commentRepository.save(comment);
    }

    @DeleteMapping()
    public void deleteComment(@PathVariable("id") Long id){
       commentService.removeComment(id);
    }
}
