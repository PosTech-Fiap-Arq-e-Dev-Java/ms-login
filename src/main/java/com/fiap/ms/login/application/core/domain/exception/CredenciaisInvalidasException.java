package com.fiap.ms.login.application.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CredenciaisInvalidasException extends ResponseStatusException {

    public CredenciaisInvalidasException() {
        super(HttpStatus.UNAUTHORIZED, "Usuário ou senha invalido.");
    }
}
