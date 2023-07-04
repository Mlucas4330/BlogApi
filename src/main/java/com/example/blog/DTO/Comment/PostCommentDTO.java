package com.example.blog.DTO.Comment;

import com.example.blog.DTO.Comment.CommentDTO;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class PostCommentDTO extends CommentDTO {
    private Long postId;
}
