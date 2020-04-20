package com.example.account.controller;

import com.example.account.component.EncryptComponent;
import com.example.account.entity.User;
import com.example.account.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private UserService us;
    @Autowired
    private PasswordEncoder pe;
    @Autowired
    private EncryptComponent ec;

    @PostMapping("/login")
    public void login(@RequestBody User user, HttpServletResponse response){
        Optional.ofNullable(us.getUserByNumber(user.getNumber()))
                .ifPresentOrElse(u -> {
                    if (!pe.matches(user.getPassword(), u.getPassword())) {
                        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户名或密码错误");
                    }
                    Map map = Map.of("uid", u.getId());
                    //生成加密token
                    String token = ec.encrypt(map);
                    //Header创建自定义属性token和role
                    response.setHeader("token", token);
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户名或密码错误");
                });
    }
}
