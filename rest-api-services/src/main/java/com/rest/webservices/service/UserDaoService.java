package com.rest.webservices.service;

import com.rest.webservices.model.User;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
public class UserDaoService {
    private static List<User> userList = new ArrayList<>();
    private static int userCount = 3;
    static {
        userList.add(new User(1, "Antony", new Date()));
        userList.add(new User(2, "Mei", new Date()));
        userList.add(new User(3, "Ganesh", new Date()));
    }
    public List<User> getUserList(){
        return userList;
    }
    public User createUser(User user){
        if(user.getId()==null){
            user.setId(++userCount);
        }
        userList.add(user);
        return user;
    }
    public User findOne(int id){
        for(User user: userList) {
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
}
