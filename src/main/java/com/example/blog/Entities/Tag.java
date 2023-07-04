package com.example.blog.Entities;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Post> posts;
}
