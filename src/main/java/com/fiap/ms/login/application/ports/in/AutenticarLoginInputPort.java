package com.fiap.ms.login.application.ports.in;

import com.fiap.ms.login.application.core.domain.AutenticacaoLoginDomain;

public interface AutenticarLoginInputPort {

    AutenticacaoLoginDomain buscar(final String usuario, final String senha);
}
