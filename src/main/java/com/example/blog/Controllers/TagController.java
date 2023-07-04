package com.example.blog.Controllers;

import com.example.blog.Entities.Tag;
import com.example.blog.Entities.Tag;
import com.example.blog.Repositories.PostRepository;
import com.example.blog.Repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/tag")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TagController {
    @Autowired
    private TagRepository tagRepository;

    public ResponseEntity<List<Tag>> findAll(){
        List<Tag> tags = tagRepository.findAll();
        return ResponseEntity.ok(tags);
    }

    @GetMapping("{id}")
    public ResponseEntity<Tag> findPost(@PathVariable("id") Long id) {
        Optional<Tag> tagOptional = tagRepository.findById(id);

        if (tagOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Tag post = tagOptional.get();
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public void savePost(@RequestBody Tag tag){
        tagRepository.save(tag);
    }

    @PutMapping("{id}")
    public ResponseEntity<Tag> updatePost(@PathVariable("id") Long id, @RequestBody Tag _post) {
        Optional<Tag> optionalPost = tagRepository.findById(id);

        if(optionalPost.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Tag post = optionalPost.get();
        post.setTitle(_post.getTitle());
        post.setText(_post.getText());

        try {
            Tag updatedFood = tagRepository.save(post);
            return ResponseEntity.ok(updatedFood);
        } catch(Exception error){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @DeleteMapping()
    public void destroyTag(@RequestBody Long id){
        tagRepository.deleteById(id);
    }
}
