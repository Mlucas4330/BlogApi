package com.example.blog.DTO.Like;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class LikeDTO {
    private Long userId;
}
