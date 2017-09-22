package com.theara.restful.restfulwebservice.service.impl;

import com.theara.restful.restfulwebservice.model.User;
import com.theara.restful.restfulwebservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();
    private Integer id;

    {
        for(id = 1; id < 6; id++){
            User user = new User(id, "User " + id, new Date());
            users.add(user);
        }
    }

    public List<User> getAllUsers(){
        return users;
    }

    public User getUserById(Integer id){
        User user = null;
        for(User usr : users){
            if(usr.getId().equals(id)){
                user = usr;
                break;
            }
        }
        return user;
    }

    public User save(User user){
        user.setId(id++);
        users.add(user);
        return user;
    }

}
