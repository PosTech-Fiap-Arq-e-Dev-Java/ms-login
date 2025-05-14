package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.LoginDomain;
import com.fiap.ms.login.application.core.domain.exception.UserNotFoundException;
import com.fiap.ms.login.application.ports.in.GetLoginInputPort;
import com.fiap.ms.login.application.ports.out.GetLoginOutputPort;

public class GetLoginUseCase implements GetLoginInputPort {

    private final GetLoginOutputPort getLoginOutputPort;

    public GetLoginUseCase(GetLoginOutputPort getLoginOutputPort) {
        this.getLoginOutputPort = getLoginOutputPort;
    }

    @Override
    public LoginDomain find(String usuario) {
        return getLoginOutputPort.findUsuarioStatusByUsuario(usuario)
                .orElseThrow(() -> new UserNotFoundException(usuario));
    }
}
