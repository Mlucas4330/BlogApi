package com.example.blog.DTO.Comment;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class CommentCommentDTO extends CommentDTO {
    private Long commentId;
}
