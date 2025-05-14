package com.fiap.ms.login.application.ports.in;

import com.fiap.ms.login.application.core.domain.AuthLoginDomain;

public interface AuthLoginInputPort {

    AuthLoginDomain find(final String usuario, final String senha);
}
