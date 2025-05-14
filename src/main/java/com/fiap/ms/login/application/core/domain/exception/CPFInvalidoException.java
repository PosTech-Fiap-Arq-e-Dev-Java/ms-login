package com.fiap.ms.login.application.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CPFInvalidoException extends ResponseStatusException {

    public CPFInvalidoException(String documento) {
        super(HttpStatus.BAD_REQUEST, "CPF inválido: " + documento);
    }
}
