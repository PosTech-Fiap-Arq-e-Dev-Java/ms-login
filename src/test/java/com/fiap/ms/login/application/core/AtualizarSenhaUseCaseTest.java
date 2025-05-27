package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.AtualizarSenhaDomain;
import com.fiap.ms.login.application.core.domain.UsuarioDomain;
import com.fiap.ms.login.application.core.domain.exception.CredenciaisInvalidasException;
import com.fiap.ms.login.application.core.domain.exception.UsuarioLoginObrigatorioException;
import com.fiap.ms.login.application.handler.SenhaValidadorHandler;
import com.fiap.ms.login.application.ports.out.AtualizarSenhaOutputPort;
import com.fiap.ms.login.application.ports.out.BuscarUsuarioOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class AtualizarSenhaUseCaseTest {

    private AtualizarSenhaOutputPort atualizarSenhaOutputPort;
    private BuscarUsuarioOutputPort buscarUsuarioOutputPort;
    private SenhaValidadorHandler senhaValidadorHandler;
    private AtualizarSenhaUseCase atualizarSenhaUseCase;

    @BeforeEach
    void setUp() {
        atualizarSenhaOutputPort = mock(AtualizarSenhaOutputPort.class);
        buscarUsuarioOutputPort = mock(BuscarUsuarioOutputPort.class);
        senhaValidadorHandler = mock(SenhaValidadorHandler.class);
        atualizarSenhaUseCase = new AtualizarSenhaUseCase(atualizarSenhaOutputPort, buscarUsuarioOutputPort, senhaValidadorHandler);
    }

    @Test
    void deveAtualizarSenhaComSucesso() {
        String usuario = "user123";
        AtualizarSenhaDomain atualizarSenhaDomain = new AtualizarSenhaDomain();
        atualizarSenhaDomain.setSenhaAntiga("oldPass");
        atualizarSenhaDomain.setSenhaNova("newPass");

        UsuarioDomain usuarioDomain = new UsuarioDomain();
        usuarioDomain.setUsuario(usuario);
        usuarioDomain.setSenha("oldPass");

        when(buscarUsuarioOutputPort.buscarUsuarioESenha(usuario, "oldPass"))
                .thenReturn(Optional.of(usuarioDomain));

        atualizarSenhaUseCase.atualizar(usuario, atualizarSenhaDomain);

        verify(senhaValidadorHandler).validarTrocaDeSenha(atualizarSenhaDomain);
        verify(buscarUsuarioOutputPort).buscarUsuarioESenha(usuario, "oldPass");
        verify(atualizarSenhaOutputPort).atualizar(usuarioDomain);

        assertEquals("newPass", usuarioDomain.getSenha());
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioEhNull() {
        AtualizarSenhaDomain atualizarSenhaDomain = new AtualizarSenhaDomain();
        atualizarSenhaDomain.setSenhaAntiga("old");
        atualizarSenhaDomain.setSenhaNova("new");

        assertThrows(UsuarioLoginObrigatorioException.class, () -> {
            atualizarSenhaUseCase.atualizar(null, atualizarSenhaDomain);
        });

        verifyNoInteractions(senhaValidadorHandler, buscarUsuarioOutputPort, atualizarSenhaOutputPort);
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioEhVazio() {
        AtualizarSenhaDomain atualizarSenhaDomain = new AtualizarSenhaDomain();
        atualizarSenhaDomain.setSenhaAntiga("old");
        atualizarSenhaDomain.setSenhaNova("new");

        assertThrows(UsuarioLoginObrigatorioException.class, () -> {
            atualizarSenhaUseCase.atualizar("   ", atualizarSenhaDomain);
        });

        verifyNoInteractions(senhaValidadorHandler, buscarUsuarioOutputPort, atualizarSenhaOutputPort);
    }

    @Test
    void deveLancarExcecaoQuandoCredenciaisInvalidas() {
        String usuario = "user123";
        AtualizarSenhaDomain atualizarSenhaDomain = new AtualizarSenhaDomain();
        atualizarSenhaDomain.setSenhaAntiga("oldPass");
        atualizarSenhaDomain.setSenhaNova("newPass");

        when(buscarUsuarioOutputPort.buscarUsuarioESenha(usuario, "oldPass"))
                .thenReturn(Optional.empty());

        assertThrows(CredenciaisInvalidasException.class, () -> {
            atualizarSenhaUseCase.atualizar(usuario, atualizarSenhaDomain);
        });

        verify(senhaValidadorHandler).validarTrocaDeSenha(atualizarSenhaDomain);
        verify(buscarUsuarioOutputPort).buscarUsuarioESenha(usuario, "oldPass");
        verifyNoMoreInteractions(atualizarSenhaOutputPort);
    }
}
