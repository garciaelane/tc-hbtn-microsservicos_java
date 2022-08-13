package com.example.user.controller;

import com.example.user.exception.CPFException;
import com.example.user.exception.UserIdException;
import com.example.user.exception.UserNameException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserController {

    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id){
        if (id < 0 || id > 100){
            throw new UserIdException();
        }
        return "You have entered valid ID";
    }


    @GetMapping("/user-name/{userName}")
    public String findUserByUserName(@PathVariable String userName){
        if (userName.length() < 3 || userName.length() > 15){
            throw new UserNameException();
        }
        return "You have entered valid USERNAME";
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf){
        if (cpf.length() < 3 || cpf.length() > 15){
            throw new CPFException();
        }
        return "You have entered valid CPF";
    }
}
