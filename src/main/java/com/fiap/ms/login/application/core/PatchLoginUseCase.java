package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.LoginDomain;
import com.fiap.ms.login.application.core.domain.UpdatePasswordDomain;
import com.fiap.ms.login.application.ports.in.PatchLoginInputPort;
import com.fiap.ms.login.application.ports.out.GetLoginOutputPort;
import com.fiap.ms.login.application.ports.out.PatchLoginOutputPort;

public class PatchLoginUseCase implements PatchLoginInputPort {

    private final PatchLoginOutputPort patchLoginOutputPort;
    private final GetLoginOutputPort getLoginOutputPort;

    public PatchLoginUseCase(PatchLoginOutputPort patchLoginOutputPort,
                             GetLoginOutputPort getLoginOutputPort) {
        this.patchLoginOutputPort = patchLoginOutputPort;
        this.getLoginOutputPort = getLoginOutputPort;
    }

    @Override
    public void update(String usuario, UpdatePasswordDomain updatePasswordDomain) {
        var domain = getLoginOutputPort.findUsuarioSenhaByUsuario(usuario, updatePasswordDomain.getSenhaAntiga())
                .orElseThrow(() -> new RuntimeException("Invalid username or password."));
        domain.setSenha(updatePasswordDomain.getSenhaNova());
        patchLoginOutputPort.update(domain);
    }
}
