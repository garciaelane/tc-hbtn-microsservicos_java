package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/messages")
public class MessageResource {

    @GetMapping("/simpleMessageWelcome")
    @ResponseBody
    public String simpleMessageWelcome() {

        return "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";
    }

    @GetMapping("/login")
    @ResponseBody
    public String login(@RequestParam String user, @RequestParam String password) {

        String message = "LOGIN EFETUADO COM SUCESSO !!!";

        if (user.isEmpty()|| password.isEmpty()) {
            message = "USUÁRIO E SENHA NÃO INFORMADOS";
        } else if (user.length() > 15 || password.length() > 15) {
            message = "USUÁRIO E SENHA INVÁLIDOS";
        }

        return message;
    }

}
