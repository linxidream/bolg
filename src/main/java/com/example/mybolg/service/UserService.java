package com.example.mybolg.service;

import com.example.mybolg.dao.UserDao;
import com.example.mybolg.entity.User;
import com.example.mybolg.security.shiro.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAll(){
        return userDao.findAll();
    }

    public UserPojo userLogin(String name){
        UserPojo userPojo=new UserPojo();
        userPojo=userDao.findByUserName(name);
        return userPojo;
    }


}
