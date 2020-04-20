package com.example.account.base_test;

import com.example.account.entity.User;
import com.example.account.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private UserService us;

    @Test
    public void addUserTest(){
        User user = new User();
        user.setName("小可爱");
        user.setNumber("001");
        us.addUser(user);
        log.debug(user.getName());
    }
}
