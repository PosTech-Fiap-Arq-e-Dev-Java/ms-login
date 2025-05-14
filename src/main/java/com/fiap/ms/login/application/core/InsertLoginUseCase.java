package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.LoginDomain;
import com.fiap.ms.login.application.core.domain.enums.StatusUsuarioEnum;
import com.fiap.ms.login.application.core.domain.enums.TipoUsuarioEnum;
import com.fiap.ms.login.application.core.domain.exception.UserAlreadyExistsException;
import com.fiap.ms.login.application.ports.in.InsertLoginInputPort;
import com.fiap.ms.login.application.ports.out.InsertLoginOutputPort;
import com.fiap.ms.login.application.ports.out.GetLoginOutputPort;

public class InsertLoginUseCase implements InsertLoginInputPort {

    private final InsertLoginOutputPort insertLoginOutputPort;
    private final GetLoginOutputPort getLoginOutputPort;


    public InsertLoginUseCase(InsertLoginOutputPort insertLoginOutputPort,
                              GetLoginOutputPort getLoginOutputPort) {
        this.insertLoginOutputPort = insertLoginOutputPort;
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
        insertLoginOutputPort.insert(customer);
    }
}
