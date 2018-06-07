package com.example.rest.webservices.restfulwebservices.resource;

import com.example.rest.webservices.restfulwebservices.bean.Post;
import com.example.rest.webservices.restfulwebservices.bean.User;
import com.example.rest.webservices.restfulwebservices.exception.PostNotFoundException;
import com.example.rest.webservices.restfulwebservices.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
public class PostResource {

    @Autowired
    private PostRepository repository;

    @GetMapping("/users/{userId}/posts")
    public List<Post> retrieveAllPosts(@PathVariable int userId){
        return repository.findByUser(new User(userId));
    }

    @GetMapping("/users/{userId}/posts/{postId}")
    public Post retrieveUser(@PathVariable int userId, @PathVariable int postId){
        Post post = repository.findByUserAndAndPostId(new User(userId), postId);

        if (Objects.isNull(post)){
            throw new PostNotFoundException("postId:".concat(String.valueOf(postId)));
        }

        return post;
    }

    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<Object> createPostForUser(@RequestBody Post post, @PathVariable int userId){
        post.setUser(new User(userId));
        Post postSaved = repository.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(postSaved.getPostId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{userId}/posts/{postId}")
    public void deletePostForUser(@PathVariable int userId, @PathVariable int postId){
        Post post = repository.findByUserAndAndPostId(new User(userId), postId);

        if (Objects.isNull(post)){
            throw new PostNotFoundException("postId:".concat(String.valueOf(postId)));
        }

        repository.delete(post);
    }
}
