package com.fiap.ms.login.application.ports.out;

import com.fiap.ms.login.application.core.domain.Login;

import java.util.Optional;

public interface GetLoginOutputPort {

    Optional<Login> find(String cpf);
}
