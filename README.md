# Projeto de Transações

## Descrição

Este projeto é um serviço de gerenciamento de transações financeiras.
Ele permite a criação, listagem, consulta e estorno de transações utilizando
um sistema RESTful. As transações contêm informações sobre o cartão utilizado,
a descrição da transação, e a forma de pagamento.

## Estrutura do Projeto

- config: Configurações do projeto.
- controller: Gerencia as requisições HTTP e chama os serviços apropriados.
- converter: Conversores de dados entre diferentes formatos.
- deserializer: Deserializadores personalizados para conversão de dados.
- dto: Define os objetos de transferência de dados entre as camadas do sistema.
- exception: Classes de exceção personalizadas.
- model: Define as entidades do sistema.
- repository: Interface para acesso aos dados persistidos.
- service: Contém a lógica de negócios.

## Endpoints

### Listar Transações

- Endpoint: GET /transacoes
- Descrição: Retorna uma lista de todas as transações.
- Resposta:

````json
{
  "transacao": [
    {
      "id": 1,
      "cartao": "1234-5678-9101-1121",
      "descricao": {
        "valor": "100.00",
        "dataHora": "21/07/2024 12:00:00",
        "estabelecimento": "Loja XYZ",
        "nsu": "123456",
        "codigoAutorizacao": "654321",
        "status": "APROVADO"
      },
      "formaPagamento": {
        "tipo": "AVISTA",
        "parcelas": "1"
      }
    }
  ]
}
````

### Buscar Transação por ID

- Endpoint: GET /transacoes/{id}
- Descrição: Retorna os detalhes de uma transação específica.
- Resposta:

````json
{
  "transacao": [
    {
      "id": 1,
      "cartao": "1234-5678-9101-1121",
      "descricao": {
        "valor": "100.00",
        "dataHora": "21/07/2024 12:00:00",
        "estabelecimento": "Loja XYZ",
        "nsu": "123456",
        "codigoAutorizacao": "654321",
        "status": "APROVADO"
      },
      "formaPagamento": {
        "tipo": "AVISTA",
        "parcelas": "1"
      }
    }
  ]
}
````

### Realizar Pagamento

- Endpoint: POST /transacoes/pagamento
- Descrição: Cria uma nova transação de pagamento.
- Requisição:

````json
{
  "transacao": [
    {
      "id": 1,
      "cartao": "1234-5678-9101-1121",
      "descricao": {
        "valor": "100.00",
        "dataHora": "21/07/2024 12:00:00",
        "estabelecimento": "Loja XYZ"
      },
      "formaPagamento": {
        "tipo": "AVISTA",
        "parcelas": "1"
      }
    }
  ]
}
````

- Resposta:

````json
{
  "transacao": [
    {
      "id": 1,
      "cartao": "1234-5678-9101-1121",
      "descricao": {
        "valor": "100.00",
        "dataHora": "21/07/2024 12:00:00",
        "estabelecimento": "Loja XYZ",
        "nsu": "123456",
        "codigoAutorizacao": "654321",
        "status": "APROVADO"
      },
      "formaPagamento": {
        "tipo": "AVISTA",
        "parcelas": "1"
      }
    }
  ]
}
````

### Realizar Estorno

- Endpoint: PUT /transacoes/estorno/{id}
- Descrição: Realiza o estorno de uma transação existente.
- Resposta:

````json
{
  "transacao": {
    "id": 1,
    "cartao": "1234-5678-9101-1121",
    "descricao": {
      "valor": "100.00",
      "dataHora": "21/07/2024 12:00:00",
      "estabelecimento": "Loja XYZ",
      "nsu": "123456",
      "codigoAutorizacao": "654321",
      "status": "CANCELADO"
    },
    "formaPagamento": {
      "tipo": "AVISTA",
      "parcelas": "1"
    }
  }
}
````

## Testes

Os testes unitários foram escritos para garantir que os endpoints do controlador
e os métodos do repositório estão funcionando corretamente. Utilizamos o JUnit para os testes.

### Testes de Controller

#### Exemplo de Teste para Listar Transações

````java
import com.toolschallenge.dto.response.MultipleTransacaoResponseDTO;
import com.toolschallenge.dto.response.TransacaoResponseDTO;
import com.toolschallenge.service.TransacaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

        ResponseEntity<MultipleTransacaoResponseDTO> response = transacaoController.listarTransacoes();
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getTransacao());
        assertEquals(1, response.getBody().getTransacao().size());
        assertEquals("1234-5678-9101-1121", response.getBody().getTransacao().get(0).getCartao());
    }
}
````

### Testes de Repositório

#### Exemplo de Teste para Realizar Pagamento

````java
package com.toolschallenge;

import com.toolschallenge.model.*;
import com.toolschallenge.repository.TransacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TransacaoRepositoryTest {

    private TransacaoRepository transacaoRepository;
    private Transacao transacao;

    @BeforeEach
    void setUp() {
        transacaoRepository = new TransacaoRepository();
        transacao = new Transacao();
        transacao.setId(1L);
        transacao.setCartao("1234******1121");

        Descricao descricao = new Descricao();
        descricao.setValor("100.00");
        descricao.setDataHora(LocalDateTime.now());
        descricao.setEstabelecimento("Loja Exemplo");
        descricao.setNsu("123456");
        descricao.setCodigoAutorizacao("654321");
        descricao.setStatus(Status.AUTORIZADO);
        transacao.setDescricao(descricao);

        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setTipo(Tipo.AVISTA);
        formaPagamento.setParcelas("3");
        transacao.setFormaPagamento(formaPagamento);
    }

    @Test
    void testRealizarPagamento() {
        Transacao resultado = transacaoRepository.realizarPagamento(transacao);
        assertNotNull(resultado);
        assertEquals(transacao.getId(), resultado.getId());
    }
}
````

## Estrutura dos Testes

1. Configuração: Inicializamos os mocks usando MockitoAnnotations.openMocks(this);
   para os testes de controlador, e configuramos os objetos de teste no método setUp()
   para os testes de repositório.
2. Testes Unitários: Escrevemos testes para cada método nos controladores e repositórios,
   garantindo que os serviços chamados retornem as respostas esperadas
   e as respostas HTTP sejam corretas.
3. Verificações: Utilizamos assertNotNull, assertEquals, assertFalse e assertTrue
   para validar o retorno das chamadas aos métodos dos controladores e repositórios.

## Tecnologias Utilizadas

- Java
- Spring Boot
- JUnit
- Mockito
- Jackson

## Como Executar o Projeto

1. Clone o repositório.
2. Navegue até o diretório do projeto.
3. Execute o comando mvn spring-boot:run para iniciar o serviço.
4. Os endpoints estarão disponíveis em http://localhost:8080/transacoes.

## Executando os Testes

Para executar os testes, use o comando:

````shell
mvn test
````

Isso irá rodar todos os testes unitários definidos para o projeto.