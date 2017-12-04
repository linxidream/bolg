package com.example.mybolg.web;

import com.example.mybolg.dao.UserDao;
import com.example.mybolg.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/user/test"})
public class UserControllerTest {

    private final UserDao userDao;

    @Autowired
    public UserControllerTest(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(value="/all")
    @ResponseBody
    public List<User> userAll(){
        return userDao.findAll();
    }
}
