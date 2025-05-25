package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.exception.UsuarioLoginObrigatorioException;
import com.fiap.ms.login.application.core.domain.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.login.application.ports.in.DeletarLoginInputPort;
import com.fiap.ms.login.application.ports.out.DeletarLoginOutputPort;
import com.fiap.ms.login.application.ports.out.BuscarUsuarioOutputPort;

public class DeletarLoginUseCase implements DeletarLoginInputPort {

    private final BuscarUsuarioOutputPort buscarUsuarioOutputPort;
    private final DeletarLoginOutputPort deletarLoginOutputPort;

    public DeletarLoginUseCase(BuscarUsuarioOutputPort buscarUsuarioOutputPort,
                               DeletarLoginOutputPort deletarLoginOutputPort) {
        this.buscarUsuarioOutputPort = buscarUsuarioOutputPort;
        this.deletarLoginOutputPort = deletarLoginOutputPort;
    }

    @Override
    public void deletar(String usuario) {
        if(usuario == null || usuario.isBlank()){
            throw new UsuarioLoginObrigatorioException();
        }

        var usuarioDomain = buscarUsuarioOutputPort.buscar(usuario)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuario));

        deletarLoginOutputPort.deletar(usuarioDomain.getId());
    }
}
