package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/messages")
public class MessageResource {

    @GetMapping("/simpleMessageWelcome")
    public String simpleMessageWelcome() {
        String message = "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";
        return message;

    }

    @GetMapping("/login/{user}/{password}")
    public String login(@PathVariable String user, @PathVariable String password) {
        String message = null;

        if (user.isBlank() || password.isBlank()) {
            message = "USUÁRIO E SENHA NÃO INFORMADOS";
        } else if (user.length() > 15 || password.length() >15){
            message = "USUÁRIO E SENHA INVÁLIDOS";
        } else {
            message = "LOGIN EFETUADO COM SUCESSO !!!";
        }
        return message;
    }
}