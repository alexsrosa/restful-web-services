package com.example.rest.webservices.restfulwebservices.dao;

import com.example.rest.webservices.restfulwebservices.bean.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class PostDaoService {

    private UserDaoService service;

    private static int postsCounts = 2;

    @Autowired
    public PostDaoService(UserDaoService service) {
        this.service = service;
    }

    public List<Post> findAllPostsForUser(int userId){
        return service.findOne(userId).getPosts();
    }

    public Post save(Post post, int userId){
        if(Objects.isNull(post.getPostId())){
            post.setPostId(++postsCounts);
        }

        service.findOne(userId).addPost(post);
        return post;
    }

    public Post findOne(int userId, int postId){
        Optional<Post> first = service.findOne(userId).getPosts()
                .stream().filter(u -> u.getPostId().equals(postId)).findFirst();

        if(first.isPresent()){
            return first.get();
        }
        return null;
    }

}
