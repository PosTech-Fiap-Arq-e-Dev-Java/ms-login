package com.fiap.ms.login.application.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UsuarioJaExisteException extends ResponseStatusException {

    public UsuarioJaExisteException() {
        super(HttpStatus.CONFLICT, "Usuário já existe.");
    }
}