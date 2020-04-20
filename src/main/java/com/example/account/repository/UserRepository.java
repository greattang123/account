package com.example.account.repository;

import com.example.account.entity.User;
import com.example.account.repository.CustomizedRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CustomizedRepository<User, Integer> {
    @Query("select u from User u where u.id =:id")
    User findById(@Param("id") int id);

    @Query("select u from User u where u.number =:number")
    User findByNumber(@Param("number") String number);

    @Query("select u from User u where u.name =:name")
    User findByName(@Param("name") String name);

    @Query("from User")
    List<User> findAllUser();
}
