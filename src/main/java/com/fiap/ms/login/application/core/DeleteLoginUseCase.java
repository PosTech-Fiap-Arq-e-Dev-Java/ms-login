package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.ports.in.DeleteLoginInputPort;
import com.fiap.ms.login.application.ports.out.DeleteLoginOutputPort;
import com.fiap.ms.login.application.ports.out.GetLoginOutputPort;

public class DeleteLoginUseCase implements DeleteLoginInputPort {

    private final GetLoginOutputPort getLoginOutputPort;
    private final DeleteLoginOutputPort deleteLoginOutputPort;

    public DeleteLoginUseCase(GetLoginOutputPort getLoginOutputPort,
                              DeleteLoginOutputPort deleteLoginOutputPort) {
        this.getLoginOutputPort = getLoginOutputPort;
        this.deleteLoginOutputPort = deleteLoginOutputPort;
    }

    @Override
    public void delete(String usuario) {
        var login = getLoginOutputPort.find(usuario)
                .orElseThrow(() -> new RuntimeException("Login not found"));
        deleteLoginOutputPort.delete(login.getId());
    }
}
