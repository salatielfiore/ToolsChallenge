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

/**
 * Controlador REST para gerenciar transações.
 *
 * @author Salatiel Fiore
 */
@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;

    /**
     * Construtor para injeção de dependências.
     *
     * @param transacaoService o serviço de transações
     */
    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    /**
     * Lista todas as transações.
     *
     * @return a resposta com múltiplas transações
     */
    @GetMapping
    public ResponseEntity<MultipleTransacaoResponseDTO> listarTransacoes() {
        List<TransacaoResponseDTO> response = transacaoService.listarTransacoes();
        return ResponseEntity.ok(new MultipleTransacaoResponseDTO(response));
    }

    /**
     * Busca uma transação por ID.
     *
     * @param id o ID da transação
     * @return a resposta com a transação correspondente
     */
    @GetMapping("/{id}")
    public ResponseEntity<SingleTransacaoResponseDTO> buscarTransacoesPorId(@PathVariable Long id) {
        TransacaoResponseDTO response = transacaoService.buscarTransacaoPorId(id);
        return ResponseEntity.ok(new SingleTransacaoResponseDTO(response));
    }

    /**
     * Realiza um pagamento.
     *
     * @param dto o DTO de requisição de transação
     * @return a resposta com a transação realizada
     */
    @PostMapping(value = "/pagamento")
    public ResponseEntity<SingleTransacaoResponseDTO> transacao(@Valid @RequestBody SingleTransacaoRequestDTO dto) {
        TransacaoResponseDTO response = transacaoService.realizarPagamento(dto.getTransacao());
        return ResponseEntity.ok(new SingleTransacaoResponseDTO(response));
    }

    /**
     * Realiza um estorno de uma transação.
     *
     * @param id o ID da transação a ser estornada
     * @return a resposta com a transação estornada
     */
    @PutMapping(value = "/estorno/{id}")
    public ResponseEntity<SingleTransacaoResponseDTO> transacao(@PathVariable Long id) {
        TransacaoResponseDTO response = transacaoService.realizarEstorno(id);
        return ResponseEntity.ok(new SingleTransacaoResponseDTO(response));
    }

}
