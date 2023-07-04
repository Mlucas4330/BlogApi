package com.example.blog.Entities;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@Entity(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String text;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @ManyToMany
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

    @OneToMany(mappedBy = "post")
    private List<Like> likes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
