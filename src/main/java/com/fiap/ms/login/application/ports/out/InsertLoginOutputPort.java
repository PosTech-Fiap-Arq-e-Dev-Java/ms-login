package com.fiap.ms.login.application.ports.out;

import com.fiap.ms.login.application.core.domain.LoginDomain;

public interface InsertLoginOutputPort {

    void insert(LoginDomain customer);
}
