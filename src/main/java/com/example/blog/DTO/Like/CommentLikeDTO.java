package com.example.blog.DTO.Like;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class CommentLikeDTO extends LikeDTO {
    private Long commentId;
}
