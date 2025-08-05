package com.fiap.ms.login.adapters.in.controller.handler;

import com.fiap.ms.login.application.core.domain.exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.OffsetDateTime;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler handler;

    private WebRequest webRequest;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        handler = new GlobalExceptionHandler();

        // Mock WebRequest returning a sample URI path
        MockHttpServletRequest servletRequest = new MockHttpServletRequest();
        servletRequest.setRequestURI("/teste/path");
        webRequest = new ServletWebRequest(servletRequest);
    }

    @SuppressWarnings("unchecked")
    @Test
    void handleNoHandlerFoundException_deveRetornarBadRequest() {
        NoHandlerFoundException ex = new NoHandlerFoundException("GET", "/wrong/path", null);
        ResponseEntity<Object> response = handler.handleNoHandlerFoundException(ex, webRequest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

        Map<String, Object> body = (Map<String, Object>) response.getBody();
        assertThat(body).isNotNull();
        assertThat(body.get("error")).isEqualTo("Bad Request");
        assertThat(body.get("message")).isEqualTo("Endpoint inválido. Verifique a URL.");
        assertThat(body.get("path")).isEqualTo("/teste/path");
        assertThat(body.get("timestamp")).isInstanceOf(OffsetDateTime.class);
    }

    @SuppressWarnings("unchecked")
    @Test
    void handleMissingParams_deveRetornarBadRequestComNomeParametro() {
        MissingServletRequestParameterException ex =
                new MissingServletRequestParameterException("usuario", "String");
        ResponseEntity<Object> response = handler.handleMissingParams(ex, webRequest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

        Map<String, Object> body = (Map<String, Object>) response.getBody();
        assertThat(body).isNotNull();
        assertThat(body.get("message")).isEqualTo("O parâmetro 'usuario' é obrigatório.");
        assertThat(body.get("path")).isEqualTo("/teste/path");
    }

    @SuppressWarnings("unchecked")
    @Test
    void handleUsuarioJaExisteException_deveRetornarConflict() {
        UsuarioJaExisteException ex = new UsuarioJaExisteException();
        ResponseEntity<Object> response = handler.handleUsuarioJaExisteException(ex, webRequest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);

        Map<String, Object> body = (Map<String, Object>) response.getBody();
        assert body != null;
        assertThat(body.get("error")).isEqualTo("CONFLICT");
        assertThat(body.get("message")).isEqualTo("Usuário ou Documento já existe.");
    }

    @SuppressWarnings("unchecked")
    @Test
    void handleCredenciaisInvalidasException_deveRetornarUnauthorized() {
        CredenciaisInvalidasException ex = new CredenciaisInvalidasException();
        ResponseEntity<Object> response = handler.handleCredenciaisInvalidasException(ex, webRequest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);

        Map<String, Object> body = (Map<String, Object>) response.getBody();
        assert body != null;
        assertThat(body.get("error")).isEqualTo("Unauthorized");
        assertThat(body.get("message")).isEqualTo("Usuário ou senha invalido.");
    }

    @SuppressWarnings("unchecked")
    @Test
    void handleUsuarioNaoEncontradoException_deveRetornarNotFound() {
        UsuarioNaoEncontradoException ex = new UsuarioNaoEncontradoException("Usuário não encontrado");
        ResponseEntity<Object> response = handler.handleUsuarioNaoEncontradoException(ex, webRequest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

        Map<String, Object> body = (Map<String, Object>) response.getBody();
        assert body != null;
        assertThat(body.get("error")).isEqualTo("Not Found");
    }

    @SuppressWarnings("unchecked")
    @Test
    void handleCPFCNPJInvalidoException_deveRetornarBadRequest() {
        CPFCNPJInvalidoException ex = new CPFCNPJInvalidoException("CPF/CNPJ inválido");
        ResponseEntity<Object> response = handler.handleCPFCNPJInvalidoException(ex, webRequest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

        Map<String, Object> body = (Map<String, Object>) response.getBody();
        assert body != null;
        assertThat(body.get("error")).isEqualTo("Bad Request");
    }

    @SuppressWarnings("unchecked")
    @Test
    void handleDocumentoInvalidoException_deveRetornarBadRequest() {
        DocumentoInvalidoException ex = new DocumentoInvalidoException("Documento inválido");
        ResponseEntity<Object> response = handler.handleDocumentoInvalidoException(ex, webRequest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

        Map<String, Object> body = (Map<String, Object>) response.getBody();
        assert body != null;
        assertThat(body.get("error")).isEqualTo("Bad Request");;
    }

    @SuppressWarnings("unchecked")
    @Test
    void handleCampoObrigatorio_deveRetornarBadRequest() {
        CampoObrigatorioException ex = new CampoObrigatorioException();
        ResponseEntity<Object> response = handler.handleCampoObrigatorio(ex, webRequest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

        Map<String, Object> body = (Map<String, Object>) response.getBody();
        assert body != null;
        assertThat(body.get("error")).isEqualTo("BAD_REQUEST");
        assertThat(body.get("message")).isEqualTo("Parâmetro obrigatório não informado.");
    }

    @SuppressWarnings("unchecked")
    @Test
    void handleSenhasIguais_deveRetornarConflict() {
        SenhasIguaisException ex = new SenhasIguaisException();
        ResponseEntity<Object> response = handler.handleSenhasIguais(ex, webRequest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);

        Map<String, Object> body = (Map<String, Object>) response.getBody();
        assert body != null;
        assertThat(body.get("error")).isEqualTo("CONFLICT");
        assertThat(body.get("message")).isEqualTo("A nova senha não pode ser igual à senha atual.");
    }

    @SuppressWarnings("unchecked")
    @Test
    void handleLoginObrigatorio_deveRetornarBadRequest() {
        UsuarioLoginObrigatorioException ex = new UsuarioLoginObrigatorioException();
        ResponseEntity<Object> response = handler.handleLoginObrigatorio(ex, webRequest);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

        Map<String, Object> body = (Map<String, Object>) response.getBody();
        assert body != null;
        assertThat(body.get("error")).isEqualTo("BAD_REQUEST");
        assertThat(body.get("message")).isEqualTo("O usuário é obrigatório.");
    }


}

