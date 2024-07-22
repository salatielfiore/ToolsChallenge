package com.toolschallenge;

import com.toolschallenge.controller.TransacaoController;
import com.toolschallenge.dto.request.SingleTransacaoRequestDTO;
import com.toolschallenge.dto.request.TransacaoRequestDTO;
import com.toolschallenge.dto.response.MultipleTransacaoResponseDTO;
import com.toolschallenge.dto.response.SingleTransacaoResponseDTO;
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

/**
 * Testes unitários para o controlador {@link TransacaoController}.
 * <p>
 * Este conjunto de testes verifica o comportamento dos métodos do controlador {@link TransacaoController}.
 * Utiliza o Mockito para simular as interações com o serviço {@link TransacaoService} e validar as respostas
 * do controlador.
 *
 * @author Salatiel Fiore
 */
class TransacaoControllerTest {

    @InjectMocks
    private TransacaoController transacaoController;

    @Mock
    private TransacaoService transacaoService;

    /**
     * Configuração inicial dos mocks antes de cada teste.
     * Inicializa os mocks com a anotação {@link MockitoAnnotations}.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Testa o método {@link TransacaoController#listarTransacoes()}.
     * Verifica se o controlador retorna a lista de transações corretamente.
     */
    @Test
    void testListarTransacoes() {
        TransacaoResponseDTO responseDTO = new TransacaoResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setCartao("1234-5678-9101-1121");

        when(transacaoService.listarTransacoes()).thenReturn(List.of(responseDTO));

        ResponseEntity<MultipleTransacaoResponseDTO> response = transacaoController.listarTransacoes();
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getTransacao());
        assertEquals(1, response.getBody().getTransacao().size());
        assertEquals("1234-5678-9101-1121", response.getBody().getTransacao().get(0).getCartao());
    }

    /**
     * Testa o método {@link TransacaoController#buscarTransacoesPorId(Long)}.
     * Verifica se o controlador retorna a transação específica pelo ID corretamente.
     */
    @Test
    void testBuscarTransacoesPorId() {
        TransacaoResponseDTO responseDTO = new TransacaoResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setCartao("1234-5678-9101-1121");

        when(transacaoService.buscarTransacaoPorId(anyLong())).thenReturn(responseDTO);

        ResponseEntity<SingleTransacaoResponseDTO> response = transacaoController.buscarTransacoesPorId(1L);
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals("1234-5678-9101-1121", response.getBody().getTransacao().getCartao());
    }

    /**
     * Testa o método {@link TransacaoController#transacao(SingleTransacaoRequestDTO)}.
     * Verifica se o controlador realiza o pagamento e retorna a transação corretamente.
     */
    @Test
    void testTransacaoPagamento() {
        SingleTransacaoRequestDTO requestDTO = new SingleTransacaoRequestDTO();
        TransacaoResponseDTO responseDTO = new TransacaoResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setCartao("1234-5678-9101-1121");

        when(transacaoService.realizarPagamento(any(TransacaoRequestDTO.class))).thenReturn(responseDTO);

        requestDTO.setTransacao(new TransacaoRequestDTO());

        ResponseEntity<SingleTransacaoResponseDTO> response = transacaoController.transacao(requestDTO);
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals("1234-5678-9101-1121", response.getBody().getTransacao().getCartao());
    }

    /**
     * Testa o método {@link TransacaoController#transacao(Long)}.
     * Verifica se o controlador realiza o estorno e retorna a transação corretamente.
     */
    @Test
    void testTransacaoEstorno() {
        TransacaoResponseDTO responseDTO = new TransacaoResponseDTO();
        responseDTO.setId(1L);
        responseDTO.setCartao("1234-5678-9101-1121");

        when(transacaoService.realizarEstorno(anyLong())).thenReturn(responseDTO);

        ResponseEntity<SingleTransacaoResponseDTO> response = transacaoController.transacao(1L);
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals("1234-5678-9101-1121", response.getBody().getTransacao().getCartao());
    }
}
