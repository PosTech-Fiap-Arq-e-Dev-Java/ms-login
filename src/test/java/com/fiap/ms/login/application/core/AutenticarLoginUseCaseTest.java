package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.AutenticacaoLoginDomain;
import com.fiap.ms.login.application.core.domain.UsuarioDomain;
import com.fiap.ms.login.application.core.domain.enums.TipoUsuarioEnum;
import com.fiap.ms.login.application.core.domain.exception.CredenciaisInvalidasException;
import com.fiap.ms.login.application.ports.out.BuscarUsuarioOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AutenticarLoginUseCaseTest {

    private BuscarUsuarioOutputPort buscarUsuarioOutputPort;
    private AutenticarLoginUseCase autenticarLoginUseCase;

    @BeforeEach
    void setUp() {
        buscarUsuarioOutputPort = mock(BuscarUsuarioOutputPort.class);
        autenticarLoginUseCase = new AutenticarLoginUseCase(buscarUsuarioOutputPort);
    }

    @Test
    void deveRetornarAutenticacaoQuandoCredenciaisValidas() {
        String usuario = "user123";
        String senha = "senha123";

        UsuarioDomain usuarioDomain = new UsuarioDomain();
        usuarioDomain.setUsuario(usuario);
        usuarioDomain.setTipoUsuario(TipoUsuarioEnum.CLIENTE);

        when(buscarUsuarioOutputPort.buscarUsuarioESenha(usuario, senha))
                .thenReturn(Optional.of(usuarioDomain));

        AutenticacaoLoginDomain resultado = autenticarLoginUseCase.buscar(usuario, senha);

        assertNotNull(resultado);
        assertEquals(usuario, resultado.getUsuario());
        assertEquals(TipoUsuarioEnum.CLIENTE, resultado.getTipoUsuarioEnum());

        verify(buscarUsuarioOutputPort).buscarUsuarioESenha(usuario, senha);
    }

    @Test
    void deveLancarExcecaoQuandoCredenciaisInvalidas() {
        String usuario = "user123";
        String senha = "senhaErrada";

        when(buscarUsuarioOutputPort.buscarUsuarioESenha(usuario, senha))
                .thenReturn(Optional.empty());

        assertThrows(CredenciaisInvalidasException.class, () -> {
            autenticarLoginUseCase.buscar(usuario, senha);
        });

        verify(buscarUsuarioOutputPort).buscarUsuarioESenha(usuario, senha);
    }
}
