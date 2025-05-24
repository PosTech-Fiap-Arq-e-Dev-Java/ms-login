package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.AtualizarSenhaDomain;
import com.fiap.ms.login.application.core.domain.exception.CredenciaisInvalidasException;
import com.fiap.ms.login.application.core.domain.exception.UsuarioLoginObrigatorioException;
import com.fiap.ms.login.application.core.domain.exception.UsuarioNaoEncontradoException;
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
        if(usuario == null || usuario.isBlank()){
            throw new UsuarioLoginObrigatorioException();
        }

        senhaValidadorHandler.validarTrocaDeSenha(atualizarSenhaDomain);

        var usuarioDomain = buscarUsuarioOutputPort.buscarUsuarioESenha(usuario, atualizarSenhaDomain.getSenhaAntiga())
                .orElseThrow(CredenciaisInvalidasException::new);

        usuarioDomain.setSenha(atualizarSenhaDomain.getSenhaNova());
        atualizarSenhaOutputPort.atualizar(usuarioDomain);
    }
}
