package com.example.authorizationservice.service;

import com.example.authorizationservice.exceptions.InvalidCredentials;
import com.example.authorizationservice.exceptions.UnauthorizedUser;
import com.example.authorizationservice.model.Authorities;
import com.example.authorizationservice.repository.UserRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}