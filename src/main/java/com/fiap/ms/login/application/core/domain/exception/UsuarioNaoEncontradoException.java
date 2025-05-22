package com.fiap.ms.login.application.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UsuarioNaoEncontradoException extends ResponseStatusException {

    public UsuarioNaoEncontradoException(String identifier) {
        super(HttpStatus.NOT_FOUND, "Usuário não encontrado: " + identifier);
    }
}
