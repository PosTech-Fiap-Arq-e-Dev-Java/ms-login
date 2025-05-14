package com.fiap.ms.login.application.ports.in;

import com.fiap.ms.login.application.core.domain.UpdatePasswordDomain;

public interface PatchLoginInputPort {

    void update(final String usuario, UpdatePasswordDomain updatePasswordDomain);
}
