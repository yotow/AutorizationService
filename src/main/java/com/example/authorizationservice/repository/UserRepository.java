package com.example.authorizationservice.repository;

import com.example.authorizationservice.model.Authorities;
import com.example.authorizationservice.model.User;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

@RestController
public class UserRepository {
    private final ConcurrentHashMap<String, User> allowUsers;

    public UserRepository() {
        this.allowUsers = new ConcurrentHashMap<>();

        Supplier<String> getRandPass = () -> java.util.UUID.randomUUID().toString()
                .replaceAll("-", "").substring(7, 17);
        String pass = getRandPass.get();

        User user = new User("admin", pass, Authorities.WRITE, Authorities.READ, Authorities.DELETE);
        System.out.println("Password for admin is " + pass);
        this.allowUsers.put("admin", user);
    }

    public List<Authorities> getUserAuthorities(String userName, String password) {
        if (!allowUsers.containsKey(userName)) {
            return Collections.emptyList();
        }
        var user = allowUsers.get(userName);
        if (!user.getPass().equals(password)) {
            return Collections.emptyList();
        }
        return user.getAuthorities();
    }
}
