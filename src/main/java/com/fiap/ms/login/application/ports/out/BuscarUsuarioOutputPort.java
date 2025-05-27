package com.fiap.ms.login.application.ports.out;

import com.fiap.ms.login.application.core.domain.UsuarioDomain;

import java.util.Optional;

public interface BuscarUsuarioOutputPort {

    Optional<UsuarioDomain> buscar(String usuario);
    Optional<UsuarioDomain> buscarUsuarioOuDocumento(String usuario, String documento);
    Optional<UsuarioDomain> buscarUsuarioESenha(String usuario, String senha);

}
