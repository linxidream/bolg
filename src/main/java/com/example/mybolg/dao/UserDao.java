package com.example.mybolg.dao;

import com.example.mybolg.entity.User;
import com.example.mybolg.security.shiro.pojo.UserPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where name = #{name}")
    User selectByName(@Param("name")String name);

    //根据用户名查询用户详情
    UserPojo findByUserName(String user_name);
}
