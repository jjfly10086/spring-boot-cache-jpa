package com.jwh.demo.controller;

import com.jwh.demo.model.User;
import com.jwh.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/user/detail/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @RequestMapping("/user/update/{id}")
    public void updateUser(@PathVariable Long id,String name){
        User user = new User();
        user.setId(id);
        user.setUserName(name);
        userService.updateUser(user);
    }

    @RequestMapping("/user/login")
    public User login(String userName,String userPass){
        return userService.findUserByNameAndPass(userName,userPass);
    }

    @RequestMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
