package com.example.rest.webservices.restfulwebservices.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Classe represent Post.
 *
 * @author alexsrosa
 */
@ApiModel(description = "All details about the post.")
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer postId;

    @ApiModelProperty(notes = "Text to post by User")
    private String post;

    private LocalDateTime postDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Post() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post1 = (Post) o;
        return Objects.equals(getPostId(), post1.getPostId()) &&
                Objects.equals(getPost(), post1.getPost()) &&
                Objects.equals(getPostDate(), post1.getPostDate()) &&
                Objects.equals(getUser(), post1.getUser());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPostId(), getPost(), getPostDate(), getUser());
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", post='" + post + '\'' +
                ", postDate=" + postDate +
                ", user=" + user +
                '}';
    }
}
