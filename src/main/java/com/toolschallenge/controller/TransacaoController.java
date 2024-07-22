package com.toolschallenge.controller;

import com.toolschallenge.dto.request.SingleTransacaoRequestDTO;
import com.toolschallenge.dto.response.MultipleTransacaoResponseDTO;
import com.toolschallenge.dto.response.SingleTransacaoResponseDTO;
import com.toolschallenge.dto.response.TransacaoResponseDTO;
import com.toolschallenge.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<MultipleTransacaoResponseDTO> listarTransacoes() {
        List<TransacaoResponseDTO> response = transacaoService.listarTransacoes();
        return ResponseEntity.ok(new MultipleTransacaoResponseDTO(response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SingleTransacaoResponseDTO> buscarTransacoesPorId(@PathVariable Long id) {
        TransacaoResponseDTO response = transacaoService.buscarTransacaoPorId(id);
        return ResponseEntity.ok(new SingleTransacaoResponseDTO(response));
    }

    @PostMapping(value = "/pagamento")
    public ResponseEntity<SingleTransacaoResponseDTO> transacao(@Valid @RequestBody SingleTransacaoRequestDTO dto) {
        TransacaoResponseDTO response = transacaoService.realizarPagamento(dto.getTransacao());
        return ResponseEntity.ok(new SingleTransacaoResponseDTO(response));
    }

    @PutMapping(value = "/estorno/{id}")
    public ResponseEntity<SingleTransacaoResponseDTO> transacao(@PathVariable Long id) {
        TransacaoResponseDTO response = transacaoService.realizarEstorno(id);
        return ResponseEntity.ok(new SingleTransacaoResponseDTO(response));
    }

}
