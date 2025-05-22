package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.AtualizarSenhaDomain;
import com.fiap.ms.login.application.core.domain.exception.CredenciaisInvalidasException;
import com.fiap.ms.login.application.handler.SenhaValidadorHandler;
import com.fiap.ms.login.application.ports.in.AtualizarSenhaInputPort;
import com.fiap.ms.login.application.ports.out.BuscarUsuarioOutputPort;
import com.fiap.ms.login.application.ports.out.AtualizarSenhaOutputPort;

public class AtualizarSenhaUseCase implements AtualizarSenhaInputPort {

    private final AtualizarSenhaOutputPort atualizarSenhaOutputPort;
    private final BuscarUsuarioOutputPort buscarUsuarioOutputPort;
    private final SenhaValidadorHandler senhaValidadorHandler;

    public AtualizarSenhaUseCase(AtualizarSenhaOutputPort atualizarSenhaOutputPort,
                                 BuscarUsuarioOutputPort buscarUsuarioOutputPort,
                                 SenhaValidadorHandler senhaValidadorHandler) {
        this.atualizarSenhaOutputPort = atualizarSenhaOutputPort;
        this.buscarUsuarioOutputPort = buscarUsuarioOutputPort;
        this.senhaValidadorHandler = senhaValidadorHandler;
    }

    @Override
    public void atualizar(String usuario, AtualizarSenhaDomain atualizarSenhaDomain) {
        var usuarioDomain = buscarUsuarioOutputPort.buscarUsuarioESenha(usuario, atualizarSenhaDomain.getSenhaAntiga())
                .orElseThrow(CredenciaisInvalidasException::new);

        senhaValidadorHandler.validarTrocaDeSenha(atualizarSenhaDomain);

        usuarioDomain.setSenha(atualizarSenhaDomain.getSenhaNova());
        atualizarSenhaOutputPort.atualizar(usuarioDomain);
    }
}
