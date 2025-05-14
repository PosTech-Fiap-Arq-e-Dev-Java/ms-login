package com.fiap.ms.login.adapters.out;

import com.fiap.ms.login.adapters.out.repository.LoginRepository;
import com.fiap.ms.login.adapters.out.repository.mapper.LoginEntityMapper;
import com.fiap.ms.login.application.core.domain.LoginDomain;
import com.fiap.ms.login.application.ports.out.PatchLoginOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatchLoginAdapter implements PatchLoginOutputPort {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public void update(LoginDomain loginDomain) {
        var loginEntity = LoginEntityMapper.INSTANCE.toLoginEntity(loginDomain);
        loginRepository.atualizarSenha(loginEntity.getUsuario(), loginEntity.getSenha());
    }
}
