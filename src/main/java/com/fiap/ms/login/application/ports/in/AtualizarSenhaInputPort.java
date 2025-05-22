package com.fiap.ms.login.application.ports.in;

import com.fiap.ms.login.application.core.domain.AtualizarSenhaDomain;

public interface AtualizarSenhaInputPort {

    void atualizar(final String usuario, AtualizarSenhaDomain atualizarSenhaDomain);
}
