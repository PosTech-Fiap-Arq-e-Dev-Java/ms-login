package com.fiap.ms.login.adapters.out;

import com.fiap.ms.login.adapters.out.repository.LoginRepository;
import com.fiap.ms.login.adapters.out.repository.mapper.LoginEntityMapper;
import com.fiap.ms.login.application.core.domain.UsuarioDomain;
import com.fiap.ms.login.application.ports.out.BuscarUsuarioOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BuscarUsuarioAdapter implements BuscarUsuarioOutputPort {

    private final LoginRepository repository;

    @Override
    public Optional<UsuarioDomain> buscar(String usuario) {
        var loginEntity = repository.findLoginByUsuario(usuario);
        return loginEntity.map(LoginEntityMapper.INSTANCE::toLoginDomain);
    }

    @Override
    public Optional<UsuarioDomain> buscarUsuarioOuDocumento(String usuario, String documento) {
        var loginEntity = repository.findByUsuarioOrDocumento(usuario, documento);
        return loginEntity.map(LoginEntityMapper.INSTANCE::toLoginDomain);
    }

    @Override
    public Optional<UsuarioDomain> buscarUsuarioESenha(String usuario, String senha) {
        var loginEntity = repository.findByUsuarioAndSenha(usuario, senha);
        return loginEntity.map(LoginEntityMapper.INSTANCE::toLoginDomain);
    }
}
