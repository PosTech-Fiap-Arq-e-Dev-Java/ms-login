package com.fiap.ms.login.application.ports.out;

import com.fiap.ms.login.application.core.domain.LoginDomain;

import java.util.Optional;

public interface GetLoginOutputPort {

    Optional<LoginDomain> find(String usuario);
    Optional<LoginDomain> findByUsuarioOrDocumento(String usuario, String documento);
    Optional<LoginDomain> findUsuarioStatusByUsuario(String usuario);

}
