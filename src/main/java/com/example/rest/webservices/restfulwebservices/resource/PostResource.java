package com.example.rest.webservices.restfulwebservices.resource;

import com.example.rest.webservices.restfulwebservices.bean.Post;
import com.example.rest.webservices.restfulwebservices.bean.User;
import com.example.rest.webservices.restfulwebservices.dao.PostDaoService;
import com.example.rest.webservices.restfulwebservices.dao.UserDaoService;
import com.example.rest.webservices.restfulwebservices.exception.PostNotFoundException;
import com.example.rest.webservices.restfulwebservices.exception.UserNotFoundException;
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
    private PostDaoService service;

    @GetMapping("/users/{userId}/posts")
    public List<Post> retrieveAllPosts(@PathVariable int userId){
        return service.findAllPostsForUser(userId);
    }

    @GetMapping("/users/{userId}/posts/{postId}")
    public Post retrieveUser(@PathVariable int userId, @PathVariable int postId){
        Post post = service.findOne(userId, postId);

        if (Objects.isNull(post)){
            throw new PostNotFoundException("postId:".concat(String.valueOf(postId)));
        }

        return post;
    }

    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<Object> createPostForUser(@RequestBody Post post, @PathVariable int userId){
        Post postSaved = service.save(post, userId);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(postSaved.getPostId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
