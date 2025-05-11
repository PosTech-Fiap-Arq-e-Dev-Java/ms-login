package com.fiap.ms.login.application.ports.in;

import com.fiap.ms.login.application.core.domain.LoginDomain;

public interface AuthRegisterInputPort {

    void insert(LoginDomain customer);
}
