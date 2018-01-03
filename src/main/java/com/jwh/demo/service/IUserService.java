package com.jwh.demo.service;

import com.jwh.demo.model.User;

public interface IUserService {

    User findUserById(Long id);

    void updateUser(User user);

    void deleteUser(Long id);

    void reloadCache();

    User findUserByNameAndPass(String userName,String userPass);
}
