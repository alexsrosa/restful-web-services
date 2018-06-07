package com.example.rest.webservices.restfulwebservices.repository;

import com.example.rest.webservices.restfulwebservices.bean.Post;
import com.example.rest.webservices.restfulwebservices.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);

    Post findByUserAndAndPostId(User user, Integer postId);
}
