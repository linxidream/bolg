package com.example.mybolg.service;

import com.example.mybolg.dao.UserDao;
import com.example.mybolg.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAll(){
        return userDao.findAll();
    }

    public String userLogin(User user){
        String token="";
        return
    }
}
