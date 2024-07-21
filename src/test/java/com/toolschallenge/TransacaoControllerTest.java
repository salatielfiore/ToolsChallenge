package com.toolschallenge;

import com.toolschallenge.controller.TransacaoController;
import com.toolschallenge.dto.request.TransacaoRequestDTO;
import com.toolschallenge.dto.response.TransacaoResponseDTO;
import com.toolschallenge.service.TransacaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class TransacaoControllerTest {

    @InjectMocks
    private TransacaoController transacaoController;

    @Mock
    private TransacaoService transacaoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarTransacoes() {
        TransacaoResponseDTO responseDTO = new TransacaoResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setCartao("1234-5678-9101-1121");

        when(transacaoService.listarTransacoes()).thenReturn(List.of(responseDTO));

        ResponseEntity<List<TransacaoResponseDTO>> response = transacaoController.listarTransacoes();
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertEquals("1234-5678-9101-1121", response.getBody().get(0).getCartao());
    }

    @Test
    void testBuscarTransacoesPorId() {
        TransacaoResponseDTO responseDTO = new TransacaoResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setCartao("1234-5678-9101-1121");

        when(transacaoService.buscarTransacaoPorId(anyLong())).thenReturn(responseDTO);

        ResponseEntity<TransacaoResponseDTO> response = transacaoController.buscarTransacoesPorId(1L);
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals("1234-5678-9101-1121", response.getBody().getCartao());
    }

    @Test
    void testTransacaoPagamento() {
        TransacaoRequestDTO requestDTO = new TransacaoRequestDTO();
        TransacaoResponseDTO responseDTO = new TransacaoResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setCartao("1234-5678-9101-1121");

        when(transacaoService.realizarPagamento(any(TransacaoRequestDTO.class))).thenReturn(responseDTO);

        ResponseEntity<TransacaoResponseDTO> response = transacaoController.transacao(requestDTO);
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals("1234-5678-9101-1121", response.getBody().getCartao());
    }

    @Test
    void testTransacaoEstorno() {
        TransacaoResponseDTO responseDTO = new TransacaoResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setCartao("1234-5678-9101-1121");

        when(transacaoService.realizarEstorno(anyLong())).thenReturn(responseDTO);

        ResponseEntity<TransacaoResponseDTO> response = transacaoController.transacao(1L);
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals("1234-5678-9101-1121", response.getBody().getCartao());
    }
}
