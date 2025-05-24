package com.fiap.ms.login.application.handler;

import com.fiap.ms.login.application.core.domain.UsuarioDomain;

public interface LoginValidatorHandler {

    void validarCamposObrigatoriosLogin(UsuarioDomain usuarioDomain);
}
