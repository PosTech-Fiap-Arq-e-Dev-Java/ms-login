package com.fiap.ms.login.application.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CPFCNPJInvalidoException extends ResponseStatusException {

    public CPFCNPJInvalidoException(String documento) {
        super(HttpStatus.BAD_REQUEST, "CPF/CNPJ inválido: " + documento);
    }
}
