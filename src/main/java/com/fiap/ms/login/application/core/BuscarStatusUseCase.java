package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.UsuarioDomain;
import com.fiap.ms.login.application.core.domain.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.login.application.ports.in.BuscarUsuarioInputPort;
import com.fiap.ms.login.application.ports.out.BuscarUsuarioOutputPort;

public class BuscarStatusUseCase implements BuscarUsuarioInputPort {

    private final BuscarUsuarioOutputPort buscarUsuarioOutputPort;

    public BuscarStatusUseCase(BuscarUsuarioOutputPort buscarUsuarioOutputPort) {
        this.buscarUsuarioOutputPort = buscarUsuarioOutputPort;
    }

    @Override
    public UsuarioDomain buscar(String usuario) {
        return buscarUsuarioOutputPort.buscar(usuario)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuario));
    }
}
