package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.AutenticacaoLoginDomain;
import com.fiap.ms.login.application.core.domain.exception.CredenciaisInvalidasException;
import com.fiap.ms.login.application.ports.in.AutenticarLoginInputPort;
import com.fiap.ms.login.application.ports.out.BuscarUsuarioOutputPort;

public class AutenticarLoginUseCase implements AutenticarLoginInputPort {

    private final BuscarUsuarioOutputPort buscarUsuarioOutputPort;

    public AutenticarLoginUseCase(BuscarUsuarioOutputPort buscarUsuarioOutputPort) {
        this.buscarUsuarioOutputPort = buscarUsuarioOutputPort;
    }

    @Override
    public AutenticacaoLoginDomain buscar(String usuario, String senha) {
        var usuarioDomain = buscarUsuarioOutputPort.buscarUsuarioESenha(usuario, senha)
                .orElseThrow(CredenciaisInvalidasException::new);

        AutenticacaoLoginDomain autenticacaoLoginDomain = new AutenticacaoLoginDomain();
        autenticacaoLoginDomain.setUsuario(usuarioDomain.getUsuario());
        autenticacaoLoginDomain.setTipoUsuarioEnum(usuarioDomain.getTipoUsuario());

        return autenticacaoLoginDomain;
    }
}
