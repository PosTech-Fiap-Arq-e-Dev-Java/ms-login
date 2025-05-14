package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.AuthLoginDomain;
import com.fiap.ms.login.application.core.domain.exception.InvalidCredentialsException;
import com.fiap.ms.login.application.ports.in.AuthLoginInputPort;
import com.fiap.ms.login.application.ports.out.GetLoginOutputPort;

public class AuthLoginUseCase implements AuthLoginInputPort {

    private final GetLoginOutputPort getLoginOutputPort;

    public AuthLoginUseCase(GetLoginOutputPort getLoginOutputPort) {
        this.getLoginOutputPort = getLoginOutputPort;
    }

    @Override
    public AuthLoginDomain find(String usuario, String senha) {
        var domain = getLoginOutputPort.findUsuarioSenhaByUsuario(usuario, senha)
                .orElseThrow(InvalidCredentialsException::new);
        AuthLoginDomain authLoginDomain = new AuthLoginDomain();
        authLoginDomain.setUsuario(domain.getUsuario());
        authLoginDomain.setTipoUsuarioEnum(domain.getTipoUsuario());
        return authLoginDomain;
    }
}
