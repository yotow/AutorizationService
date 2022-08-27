package com.example.authorizationservice.model;

import org.springframework.boot.convert.DataSizeUnit;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

public class User {

    @NotBlank
    @Size(min = 2, max = 20)
    private String name;

    @NotBlank
    @Size(min = 10, max = 20)
    private String pass;
    List<Authorities> authorities;

    public User(String name, String pass, Authorities ... authorities) {
        this.name = name;
        this.pass = pass;

        this.authorities = new ArrayList<>();

        for (Authorities a :
                authorities) {
            if (!this.authorities.contains(a)) {
                this.authorities.add(a);
            }
        }
    }

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setAuthorities(Authorities... authorities) {
        this.authorities = new ArrayList<>();

        for (Authorities a :
                authorities) {
            if (!this.authorities.contains(a)) {
                this.authorities.add(a);
            }
        }
    }
}
