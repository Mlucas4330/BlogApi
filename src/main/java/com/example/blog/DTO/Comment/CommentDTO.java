package com.example.blog.DTO.Comment;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {
    private Long id;
    private Long userId;
    private String text;
}