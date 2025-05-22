package com.fiap.ms.login.adapters.out;

import com.fiap.ms.login.adapters.out.repository.LoginRepository;
import com.fiap.ms.login.adapters.out.repository.mapper.LoginEntityMapper;
import com.fiap.ms.login.application.core.domain.UsuarioDomain;
import com.fiap.ms.login.application.ports.out.AtualizarSenhaOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AtualizarSenhaAdapter implements AtualizarSenhaOutputPort {

    private final LoginRepository loginRepository;

    @Override
    public void atualizar(UsuarioDomain usuarioDomain) {
        var loginEntity = LoginEntityMapper.INSTANCE.toLoginEntity(usuarioDomain);
        loginRepository.atualizarSenha(loginEntity.getUsuario(), loginEntity.getSenha());
    }
}
