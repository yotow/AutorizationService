package com.example.authorizationservice.advice;

import com.example.authorizationservice.exceptions.InvalidCredentials;
import com.example.authorizationservice.exceptions.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandlersAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> icHandler(InvalidCredentials e){
        return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unAuthHandler(UnauthorizedUser e){
        return new ResponseEntity<>(e.toString(), HttpStatus.UNAUTHORIZED);
    }
}
