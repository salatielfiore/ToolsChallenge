package com.toolschallenge;

import com.toolschallenge.repository.TransacaoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToolschallengeApplication {

    public static void main(String[] args) {
        TransacaoRepository transacaoRepository = new TransacaoRepository();
        transacaoRepository.adicionarTransacao();
        SpringApplication.run(ToolschallengeApplication.class, args);
    }

}
