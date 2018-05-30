package com.example.rest.webservices.restfulwebservices.dao;

import com.example.rest.webservices.restfulwebservices.bean.Post;
import com.example.rest.webservices.restfulwebservices.bean.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int usersCounts = 3;

    static {

        List<Post> postsAdam =
                Arrays.asList(new Post(1, "first Post", LocalDateTime.now())
                            , new Post(2, "second Post", LocalDateTime.now()));

        users.add(new User(1, "Adam", LocalDate.now(), postsAdam));
        users.add(new User(2, "Eve", LocalDate.now()));
        users.add(new User(3, "Jack", LocalDate.now()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(Objects.isNull(user.getUserId())){
            user.setUserId(++usersCounts);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id){

        Optional<User> first = users.stream().filter(u -> u.getUserId().equals(id)).findFirst();

        if(first.isPresent()){
            return first.get();
        }
        return null;
    }

    public User deleteById(int id){

        User user = findOne(id);

        if(Objects.nonNull(user)){
            users.remove(user);
        }

        return user;
    }
}
