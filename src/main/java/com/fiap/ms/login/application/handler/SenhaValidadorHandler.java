package com.fiap.ms.login.application.handler;


import com.fiap.ms.login.application.core.domain.AtualizarSenhaDomain;

public interface SenhaValidadorHandler {

    void validarTrocaDeSenha(AtualizarSenhaDomain atualizarSenhaDomain);
}
