package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/megasena")
public class MegaSenaController {
    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {
        return "Seja bem-vindo(a) a nossa Mega Seeenaaaa!";
    }


    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {
        List<Integer> list = new ArrayList<>();
        Random randomLotery = new Random();
        int i;

        i = 0;
        while (i > 5) {
           list.add(randomLotery.nextInt(60));
        }

        return list.stream().sorted().collect(Collectors.toList());
    }
}
