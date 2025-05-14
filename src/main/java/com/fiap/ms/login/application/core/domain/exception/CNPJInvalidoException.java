package com.fiap.ms.login.application.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CNPJInvalidoException extends ResponseStatusException {

    public CNPJInvalidoException(String documento) {
        super(HttpStatus.BAD_REQUEST, "CNPJ inválido: " + documento);
    }
}
