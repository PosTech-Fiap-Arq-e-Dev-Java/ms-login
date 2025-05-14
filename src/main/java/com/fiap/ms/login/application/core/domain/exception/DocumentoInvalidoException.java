package com.fiap.ms.login.application.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DocumentoInvalidoException extends ResponseStatusException {

    public DocumentoInvalidoException(String documento) {
        super(HttpStatus.BAD_REQUEST, "Documento inválido: " + documento);
    }
}
