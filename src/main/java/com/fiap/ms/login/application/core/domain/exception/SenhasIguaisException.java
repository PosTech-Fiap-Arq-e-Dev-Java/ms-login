package com.fiap.ms.login.application.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SenhasIguaisException extends ResponseStatusException {

    public SenhasIguaisException() {
        super(HttpStatus.CONFLICT, "A nova senha não pode ser igual à senha atual.");
    }
}
