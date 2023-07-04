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
    public Tag findPost(@PathVariable("id") Long id) {
        Optional<Tag> tagOptional = tagRepository.findById(id);

        return tagOptional.orElse(null);
    }

    @PostMapping
    public void savePost(@RequestBody Tag tag){
        tagRepository.save(tag);
    }

    @PutMapping("{id}")
    public void updatePost(@PathVariable("id") Long id, @RequestBody Tag _tag) {
        Optional<Tag> optionalPost = tagRepository.findById(id);

        if(optionalPost.isEmpty()){
            return;
        }

        Tag tag = optionalPost.get();
        tag.setName(_tag.getName());
        tagRepository.save(tag);
    }

    @DeleteMapping()
    public void destroyTag(@RequestBody Long id){
        tagRepository.deleteById(id);
    }
}
