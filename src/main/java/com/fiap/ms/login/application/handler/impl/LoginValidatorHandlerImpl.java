package com.fiap.ms.login.application.handler.impl;

import com.fiap.ms.login.application.core.domain.UsuarioDomain;
import com.fiap.ms.login.application.core.domain.exception.CampoObrigatorioException;
import com.fiap.ms.login.application.handler.LoginValidatorHandler;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LoginValidatorHandlerImpl implements LoginValidatorHandler {

    @Override
    public void validarCamposObrigatoriosLogin(UsuarioDomain usuarioDomain) {
        if(Objects.isNull(usuarioDomain) || usuarioDomain.getUsuario().isBlank() || usuarioDomain.getDocumento().isBlank() || usuarioDomain.getSenha().isBlank()) {
            throw new CampoObrigatorioException();
        }
    }

}
