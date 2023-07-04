package com.example.blog.Controllers;

import com.example.blog.DTO.Like.CommentLikeDTO;
import com.example.blog.DTO.Like.PostLikeDTO;
import com.example.blog.Services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/like")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LikeController {
    @Autowired
    private LikeService likeService;


    @PostMapping
    public void likePost(@RequestBody PostLikeDTO like){
        likeService.savePostLike(like);
    }

    @PostMapping
    public void likeComment(@RequestBody CommentLikeDTO like){
        likeService.saveCommentLike(like);
    }

    @DeleteMapping()
    public void unlike(@RequestBody Long id){
        likeService.removeLike(id);
    }
}
