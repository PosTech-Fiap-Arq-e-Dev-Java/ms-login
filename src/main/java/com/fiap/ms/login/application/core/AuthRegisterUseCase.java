package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.LoginDomain;
import com.fiap.ms.login.application.core.domain.enums.StatusUsuarioEnum;
import com.fiap.ms.login.application.core.domain.enums.TipoUsuarioEnum;
import com.fiap.ms.login.application.core.domain.exception.UserAlreadyExistsException;
import com.fiap.ms.login.application.ports.in.AuthRegisterInputPort;
import com.fiap.ms.login.application.ports.out.AuthRegisterOutputPort;
import com.fiap.ms.login.application.ports.out.GetLoginOutputPort;

import java.util.Optional;

public class AuthRegisterUseCase implements AuthRegisterInputPort {

    private final AuthRegisterOutputPort authRegisterOutputPort;
    private final GetLoginOutputPort getLoginOutputPort;


    public AuthRegisterUseCase(AuthRegisterOutputPort authRegisterOutputPort,
                               GetLoginOutputPort getLoginOutputPort) {
        this.authRegisterOutputPort = authRegisterOutputPort;
        this.getLoginOutputPort = getLoginOutputPort;
    }

    @Override
    public void insert(LoginDomain customer) {
        getLoginOutputPort.findByUsuarioOrDocumento(customer.getUsuario(), customer.getDocumento())
                .ifPresent(login -> {
                    throw new UserAlreadyExistsException("User already exists");
                });

        customer.setStatusUsuario(StatusUsuarioEnum.ATIVO);
        customer.setTipoUsuario(TipoUsuarioEnum.CLIENTE);
        authRegisterOutputPort.insert(customer);
    }
}
