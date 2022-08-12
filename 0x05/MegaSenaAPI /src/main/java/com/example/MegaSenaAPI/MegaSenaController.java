package com.song.MegaSenaAPI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value="/megasena")
public class MegaSenaController {


    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {
        return "Bem vindo a API REST para geração de números para a loteria Mega Sena";
    }


    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {

        List<Integer> numerosSorteados = new ArrayList<>();
        Random randomNumber = new Random();

        while(numerosSorteados.size() < 6) {
            Integer sorteio = randomNumber.nextInt(60);
            if (!numerosSorteados.contains(sorteio)){
                numerosSorteados.add(sorteio);
            }
        }

        Collections.sort(numerosSorteados);

        return numerosSorteados;
    }
}
