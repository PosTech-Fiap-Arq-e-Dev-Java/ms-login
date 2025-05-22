package com.fiap.ms.login.application.ports.in;

import com.fiap.ms.login.application.core.domain.UsuarioDomain;

public interface BuscarUsuarioInputPort {

    UsuarioDomain buscar(String usuario);
}
