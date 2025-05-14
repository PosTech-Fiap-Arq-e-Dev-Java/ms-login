package com.fiap.ms.login.application.ports.in;

import com.fiap.ms.login.application.core.domain.LoginDomain;

public interface GetLoginInputPort {

    LoginDomain find(String usuario);
}
