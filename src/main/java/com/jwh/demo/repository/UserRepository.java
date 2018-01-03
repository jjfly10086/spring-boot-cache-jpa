package com.jwh.demo.repository;

import com.jwh.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //JPA规范命名接口
    User findUserById(Long id);
    //自定义接口命名
    @Query("select id,userName,userPass from User where user_name =:name")//JPQL语法
    List<User> findUserList(@Param("name") String userName);

}
