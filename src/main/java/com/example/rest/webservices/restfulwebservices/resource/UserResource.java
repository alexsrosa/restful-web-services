package com.example.rest.webservices.restfulwebservices.resource;

import com.example.rest.webservices.restfulwebservices.bean.User;
import com.example.rest.webservices.restfulwebservices.dao.UserDaoService;
import com.example.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public Resource<User> retrieveUser(@PathVariable int id){
        User user = service.findOne(id);

        if (Objects.isNull(user)){
            throw new UserNotFoundException("id:".concat(String.valueOf(id)));
        }

        Resource<User> resource = new Resource<>(user);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteById(id);

        if (Objects.isNull(user)){
            throw new UserNotFoundException("id:".concat(String.valueOf(id)));
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getUserId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
