package com.example.blog.Controllers;

import com.example.blog.Entities.Post;
import com.example.blog.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/post")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    public ResponseEntity<List<Post>> findAll(){
        List<Post> posts = postRepository.findAll();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("{id}")
    public ResponseEntity<Post> findPost(@PathVariable("id") Long id) {
        Optional<Post> postOptional = postRepository.findById(id);

        if (postOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Post post = postOptional.get();
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public ResponseEntity<Post> savePost(@RequestBody Post _post){
        try {
            Post post = postRepository.save(_post);
            return ResponseEntity.ok(post);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") Long id, @RequestBody Post _post) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if(optionalPost.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Post post = optionalPost.get();
        post.setTitle(_post.getTitle());
        post.setText(_post.getText());

        try {
            Post updatedFood = postRepository.save(post);
            return ResponseEntity.ok(updatedFood);
        } catch(Exception error){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> destroyPost(@PathVariable("id") Long id){
        try {
            postRepository.deleteById(id);
            return ResponseEntity.ok(id);
        } catch (Exception error){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
