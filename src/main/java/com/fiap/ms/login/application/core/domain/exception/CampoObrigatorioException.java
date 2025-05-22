package com.fiap.ms.login.application.core.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CampoObrigatorioException extends ResponseStatusException {

  public CampoObrigatorioException() {
    super(HttpStatus.BAD_REQUEST, "Parâmetro obrigatório não informado.");
  }
}
