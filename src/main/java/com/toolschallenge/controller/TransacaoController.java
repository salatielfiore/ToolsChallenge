package com.toolschallenge.controller;

import com.toolschallenge.dto.request.TransacaoRequestDTO;
import com.toolschallenge.dto.response.TransacaoResponseDTO;
import com.toolschallenge.service.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public ResponseEntity<List<TransacaoResponseDTO>> listarTransacoes() {
        List<TransacaoResponseDTO> response = transacaoService.listarTransacoes();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransacaoResponseDTO> buscarTransacoesPorId(@PathVariable Long id) {
        TransacaoResponseDTO response = transacaoService.buscarTransacaoPorId(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/pagamento")
    public ResponseEntity<TransacaoResponseDTO> transacao(@RequestBody TransacaoRequestDTO dto) {
        TransacaoResponseDTO response = transacaoService.realizarPagamento(dto);
        return ResponseEntity.ok(response);
    }



}
