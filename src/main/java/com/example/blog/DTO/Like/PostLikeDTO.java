package com.example.blog.DTO.Like;

import com.example.blog.DTO.Like.LikeDTO;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class PostLikeDTO extends LikeDTO {
    private Long postId;
}
