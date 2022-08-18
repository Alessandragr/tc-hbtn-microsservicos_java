package com.example.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserController {
    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id) {
        if(id > 0 && id <100) {
            return "You have entered valid ID";
        }
        else {
            throw new RuntimeException("You have entered invalid ID");
        }
    }

    @GetMapping("/user-name/{userName}")
    public String findUserByName(@PathVariable String userName) {
        if(userName.length()>3 && userName.length()<15) {
            return  "You have entered valid USERNAME";
        }
        else {
            throw new RuntimeException("You have entered invalid USERNAME");
        }
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) {
        if(cpf.length() >3 && cpf.length() <15) {
            return  "You have entered valid CPF";
        }
        else {
            throw new RuntimeException("You have entered invalid CPF");
        }
    }
}
