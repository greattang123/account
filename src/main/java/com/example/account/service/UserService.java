package com.example.account.service;

import com.example.account.entity.User;
import com.example.account.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository ur;
    @Autowired
    private PasswordEncoder pe;

    public User getUserById(int id) {
        return ur.findById(id);
    }

    public User getUserByName(String name) {
        return ur.findByName(name);
    }
    public User addUser(User user){
        user.setPassword(pe.encode(user.getNumber()));
        return ur.saveAndFlush(user);
    }
    public User getUserByNumber(String number){
        return ur.findByNumber(number);
    }
}
