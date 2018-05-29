package com.example.rest.webservices.restfulwebservices.bean;

import java.time.LocalDateTime;

public class Post {

    private Integer postId;
    private String post;
    private LocalDateTime postDate;

    protected Post() {

    }

    public Post(Integer postId, String post, LocalDateTime postDate) {
        this.postId = postId;
        this.post = post;
        this.postDate = postDate;
    }

    public Post(Integer postId, String post, LocalDateTime postDate, User user) {
        this.postId = postId;
        this.post = post;
        this.postDate = postDate;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPost_date(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", post='" + post + '\'' +
                ", postDate=" + postDate +
                '}';
    }
}
