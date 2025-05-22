package com.fiap.ms.login.application.ports.out;

import com.fiap.ms.login.application.core.domain.UsuarioDomain;

public interface InserirLoginOutputPort {

    void inserir(UsuarioDomain customer);
}
