package com.fiap.ms.login.adapters.out.repository;

import com.fiap.ms.login.adapters.out.repository.mapper.LoginEntityMapper;
import com.fiap.ms.login.application.core.domain.LoginDomain;
import com.fiap.ms.login.application.ports.out.GetLoginOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetLoginAdapter implements GetLoginOutputPort {

    @Autowired
    private LoginRepository repository;

    @Autowired
    private LoginEntityMapper loginEntityMapper;

    @Override
    public Optional<LoginDomain> find(String usuario) {
        var loginEntity = repository.findLoginByUsuario(usuario);
        return loginEntity.map(entity -> loginEntityMapper.toLogin(entity));
    }

    @Override
    public Optional<LoginDomain> findByUsuarioOrDocumento(String usuario, String documento) {
        var loginEntity = repository.findByUsuarioOrDocumento(usuario, documento);
        return loginEntity.map(entity -> loginEntityMapper.toLogin(entity));
    }
}
