package com.fiap.ms.login.adapters.out;

import com.fiap.ms.login.adapters.out.repository.LoginRepository;
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

    @Override
    public Optional<LoginDomain> find(String usuario) {
        var loginEntity = repository.findLoginByUsuario(usuario);
        return loginEntity.map(LoginEntityMapper.INSTANCE::toLogin);
    }

    @Override
    public Optional<LoginDomain> findByUsuarioOrDocumento(String usuario, String documento) {
        var loginEntity = repository.findByUsuarioOrDocumento(usuario, documento);
        return loginEntity.map(LoginEntityMapper.INSTANCE::toLogin);
    }

    @Override
    public Optional<LoginDomain> findUsuarioStatusByUsuario(String usuario) {
        var loginEntity = repository.findLoginByUsuario(usuario);
        return loginEntity.map(LoginEntityMapper.INSTANCE::toLogin);
    }
}
