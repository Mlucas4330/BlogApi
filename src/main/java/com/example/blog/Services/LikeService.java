package com.example.blog.Services;


import com.example.blog.DTO.Like.CommentLikeDTO;
import com.example.blog.DTO.Like.PostLikeDTO;
import com.example.blog.Repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LikeService {
    @Autowired
    private LikeRepository likeRepository;
    public void savePostLike(PostLikeDTO like) {
        likeRepository.save(like);
    }

    public void saveCommentLike(CommentLikeDTO like) {
        likeRepository.save(like);
    }

    public void removeLike(Long id){
        likeRepository.deleteById(id);
    }
}
