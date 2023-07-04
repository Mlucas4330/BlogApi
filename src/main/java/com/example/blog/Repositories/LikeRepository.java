package com.example.blog.Repositories;

import com.example.blog.DTO.Like.LikeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<LikeDTO, Long> {
}
