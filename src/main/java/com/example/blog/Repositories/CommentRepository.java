package com.example.blog.Repositories;

import com.example.blog.DTO.Comment.CommentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentDTO, Long> {
}
