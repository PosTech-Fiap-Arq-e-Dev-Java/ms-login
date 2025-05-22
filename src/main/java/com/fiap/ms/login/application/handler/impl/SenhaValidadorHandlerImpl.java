package com.fiap.ms.login.application.handler.impl;

import com.fiap.ms.login.application.core.domain.AtualizarSenhaDomain;
import com.fiap.ms.login.application.core.domain.exception.CampoObrigatorioException;
import com.fiap.ms.login.application.handler.SenhaValidadorHandler;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SenhaValidadorHandlerImpl implements SenhaValidadorHandler {

    @Override
    public void validarTrocaDeSenha(AtualizarSenhaDomain atualizarSenhaDomain) {
        if(Objects.isNull(atualizarSenhaDomain) || atualizarSenhaDomain.getSenhaNova().isBlank()) {
            throw new CampoObrigatorioException();
        }
    }
}
