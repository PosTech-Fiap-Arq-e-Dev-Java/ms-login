package com.fiap.ms.login.application.ports.out;

import com.fiap.ms.login.application.core.domain.LoginDomain;

public interface PatchLoginOutputPort {

    void update(LoginDomain loginDomain);

}
