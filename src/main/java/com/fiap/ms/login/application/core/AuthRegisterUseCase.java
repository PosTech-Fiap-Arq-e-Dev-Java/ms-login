package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.LoginDomain;
import com.fiap.ms.login.application.ports.in.AuthRegisterInputPort;
import com.fiap.ms.login.application.ports.out.AuthRegisterOutputPort;

public class AuthRegisterUseCase implements AuthRegisterInputPort {

    private final AuthRegisterOutputPort authRegisterOutputPort;

    public AuthRegisterUseCase(AuthRegisterOutputPort authRegisterOutputPort) {
        this.authRegisterOutputPort = authRegisterOutputPort;
    }

    @Override
    public void insert(LoginDomain customer) {
        authRegisterOutputPort.insert(customer);
    }
}
