package com.fiap.ms.login.adapters.out.repository;

import com.fiap.ms.login.adapters.out.BuscarUsuarioAdapter;
import com.fiap.ms.login.adapters.out.repository.entity.LoginEntity;
import com.fiap.ms.login.adapters.out.repository.mapper.LoginEntityMapper;
import com.fiap.ms.login.application.core.domain.UsuarioDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static com.fiap.ms.login.common.utils.MocksUsuario.getUsuarioDomain;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BuscarUsuarioAdapterTest {

    @Mock
    private LoginRepository repository;

    @InjectMocks
    private BuscarUsuarioAdapter buscarUsuarioAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveBuscarUsuarioComSucesso() {
        UsuarioDomain usuarioDomain = getUsuarioDomain();
        LoginEntity loginEntity = LoginEntityMapper.INSTANCE.toLoginEntity(usuarioDomain);

        when(repository.findLoginByUsuario(usuarioDomain.getUsuario())).thenReturn(Optional.of(loginEntity));

        Optional<UsuarioDomain> result = buscarUsuarioAdapter.buscar(usuarioDomain.getUsuario());

        assertTrue(result.isPresent());
        verify(repository).findLoginByUsuario(usuarioDomain.getUsuario());
        verify(repository, times(1)).findLoginByUsuario(usuarioDomain.getUsuario());
    }

    @Test
    void deveRetornarVazioQuandoNaoEncontrarUsuario() {
        String usuario = "user123";

        when(repository.findLoginByUsuario(usuario)).thenReturn(Optional.empty());

        Optional<UsuarioDomain> result = buscarUsuarioAdapter.buscar(usuario);

        assertTrue(result.isEmpty());
        verify(repository).findLoginByUsuario(usuario);
    }

    @Test
    void deveBuscarUsuarioOuDocumentoComSucesso() {
        UsuarioDomain usuarioDomain = getUsuarioDomain();
        LoginEntity loginEntity = LoginEntityMapper.INSTANCE.toLoginEntity(usuarioDomain);

        when(repository.findByUsuarioOrDocumento(usuarioDomain.getUsuario(), usuarioDomain.getDocumento())).thenReturn(Optional.of(loginEntity));

        Optional<UsuarioDomain> result = buscarUsuarioAdapter.buscarUsuarioOuDocumento(usuarioDomain.getUsuario(), usuarioDomain.getDocumento());

        assertTrue(result.isPresent());
        verify(repository).findByUsuarioOrDocumento(usuarioDomain.getUsuario(), usuarioDomain.getDocumento());
        verify(repository, times(1)).findByUsuarioOrDocumento(usuarioDomain.getUsuario(), usuarioDomain.getDocumento());
    }

    @Test
    void deveRetornarVazioQuandoNaoEncontrarUsuarioOuDocumento() {
        String usuario = "user123";
        String documento = "123456789";

        when(repository.findByUsuarioOrDocumento(usuario, documento)).thenReturn(Optional.empty());

        Optional<UsuarioDomain> result = buscarUsuarioAdapter.buscarUsuarioOuDocumento(usuario, documento);

        assertTrue(result.isEmpty());
        verify(repository).findByUsuarioOrDocumento(usuario, documento);
    }


    @Test
    void deveBuscarUsuarioESenhaComSucesso() {
        UsuarioDomain usuarioDomain = getUsuarioDomain();
        LoginEntity loginEntity = LoginEntityMapper.INSTANCE.toLoginEntity(usuarioDomain);

        when(repository.findByUsuarioAndSenha(usuarioDomain.getUsuario(), usuarioDomain.getSenha())).thenReturn(Optional.of(loginEntity));

        Optional<UsuarioDomain> result = buscarUsuarioAdapter.buscarUsuarioESenha(usuarioDomain.getUsuario(), usuarioDomain.getSenha());

        assertTrue(result.isPresent());
        verify(repository).findByUsuarioAndSenha(usuarioDomain.getUsuario(), usuarioDomain.getSenha());
        verify(repository, times(1)).findByUsuarioAndSenha(usuarioDomain.getUsuario(), usuarioDomain.getSenha());

    }

    @Test
    void deveRetornarVazioQuandoNaoEncontrarUsuarioESenha() {
        String usuario = "user123";
        String senha = "senhaSecreta";

        when(repository.findByUsuarioAndSenha(usuario, senha)).thenReturn(Optional.empty());

        Optional<UsuarioDomain> result = buscarUsuarioAdapter.buscarUsuarioESenha(usuario, senha);

        assertTrue(result.isEmpty());
        verify(repository).findByUsuarioAndSenha(usuario, senha);
    }
}
