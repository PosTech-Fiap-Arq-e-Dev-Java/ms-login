package com.fiap.ms.login.adapters.out;

import com.fiap.ms.login.adapters.out.repository.LoginRepository;
import com.fiap.ms.login.adapters.out.repository.mapper.LoginEntityMapper;
import com.fiap.ms.login.application.core.domain.UsuarioDomain;
import com.fiap.ms.login.application.ports.out.AtualizarSenhaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtualizarSenhaAdapter implements AtualizarSenhaOutputPort {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public void atualizar(UsuarioDomain usuarioDomain) {
        var loginEntity = LoginEntityMapper.INSTANCE.toLoginEntity(usuarioDomain);
        loginRepository.atualizarSenha(loginEntity.getUsuario(), loginEntity.getSenha());
    }
}
