package com.fiap.ms.login.application.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UsuarioLoginObrigatorioException extends ResponseStatusException {

        public UsuarioLoginObrigatorioException(){
        super(HttpStatus.BAD_REQUEST, "O usuário é obrigatório.");
    }
}
