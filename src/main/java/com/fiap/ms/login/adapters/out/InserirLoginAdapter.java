package com.fiap.ms.login.adapters.out;

import com.fiap.ms.login.adapters.out.repository.LoginRepository;
import com.fiap.ms.login.adapters.out.repository.mapper.LoginEntityMapper;
import com.fiap.ms.login.application.core.domain.UsuarioDomain;
import com.fiap.ms.login.application.ports.out.InserirLoginOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InserirLoginAdapter implements InserirLoginOutputPort {

    private final LoginRepository loginRepository;
    private final LoginEntityMapper loginEntityMapper;

    @Override
    public void inserir(UsuarioDomain login) {
        var loginEntity = loginEntityMapper.toLoginEntity(login);
        loginRepository.save(loginEntity);
    }
}
