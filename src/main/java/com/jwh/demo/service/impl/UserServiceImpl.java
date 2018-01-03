package com.jwh.demo.service.impl;

import com.jwh.demo.model.User;
import com.jwh.demo.repository.UserRepository;
import com.jwh.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Cacheable(value = "user",key = "#id")//缓存名user,当重复使用相同参数调用方法的时候，方法本身不会被调用执行(即缓存命中)；未命中则执行方法，查询DB
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    @Cacheable(value = "user",key = "#userName.concat(':').concat(#userPass)")//组合键
    public User findUserByNameAndPass(String userName, String userPass) {
        User user = new User();
        user.setUserName(userName);
        user.setUserPass(userPass);
        Example<User> example = Example.of(user);
        return userRepository.findOne(example);
    }

    @Override
    @CachePut(value = "user",key = "#user.id")//缓存名user，既能保证方法被调用，结果每次都会被缓存，即覆盖
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @CacheEvict(value = "user",key = "#id")//清除user缓存中和user.id匹配的记录，先删除执行方法，后清空缓存
    public void deleteUser(Long id){
        userRepository.delete(id);
    }
    @CacheEvict(value = "user",allEntries = true)//清空user
    public void reloadCache(){

    }
}
