package com.example.rest.webservices.restfulwebservices.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe represent User.
 *
 * @author alexsrosa
 */
@ApiModel(description = "All details about the user.")
public class User {

    private Integer userId;

    @Size(min = 2, message = "Name should have atleast 2 characters")
    @ApiModelProperty(notes = "Name should have atleast 2 characters")
    private String name;

    @Past
    @ApiModelProperty(notes = "Birth date Should be in the past")
    private LocalDate birthDate;

    private List<Post> posts = new ArrayList<>();

    protected User(){

    }

    public User(Integer userId, String name, LocalDate birthDate) {
        this.userId = userId;
        this.name = name;
        this.birthDate = birthDate;
    }

    public User(Integer userId, String name, LocalDate birthDate, List<Post> posts) {
        this.userId = userId;
        this.name = name;
        this.birthDate = birthDate;
        this.posts = posts;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return Collections.unmodifiableList(posts);
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post){
        this.posts.add(post);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", posts=" + posts +
                '}';
    }
}
