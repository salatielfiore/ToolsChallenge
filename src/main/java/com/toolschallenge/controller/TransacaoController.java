package com.toolschallenge.controller;

import com.toolschallenge.dto.request.TransacaoRequestDTO;
import com.toolschallenge.service.TransacaoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }


    @PostMapping(value = "/pagamento")
    public void transacao(@RequestBody TransacaoRequestDTO dto) {
        transacaoService.realizarPagamento(dto);
    }

}
