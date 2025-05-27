package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.UsuarioDomain;
import com.fiap.ms.login.application.core.domain.exception.UsuarioLoginObrigatorioException;
import com.fiap.ms.login.application.core.domain.exception.UsuarioNaoEncontradoException;
import com.fiap.ms.login.application.ports.out.BuscarUsuarioOutputPort;
import com.fiap.ms.login.application.ports.out.DeletarLoginOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class DeletarLoginUseCaseTest {

    private BuscarUsuarioOutputPort buscarUsuarioOutputPort;
    private DeletarLoginOutputPort deletarLoginOutputPort;
    private DeletarLoginUseCase deletarLoginUseCase;

    @BeforeEach
    void setUp() {
        buscarUsuarioOutputPort = mock(BuscarUsuarioOutputPort.class);
        deletarLoginOutputPort = mock(DeletarLoginOutputPort.class);
        deletarLoginUseCase = new DeletarLoginUseCase(buscarUsuarioOutputPort, deletarLoginOutputPort);
    }

    @Test
    void deveDeletarComSucessoQuandoUsuarioExiste() {
        String usuario = "user123";
        UsuarioDomain usuarioDomain = new UsuarioDomain();
        usuarioDomain.setId(1);
        usuarioDomain.setUsuario(usuario);

        when(buscarUsuarioOutputPort.buscar(usuario))
                .thenReturn(Optional.of(usuarioDomain));

        deletarLoginUseCase.deletar(usuario);

        verify(buscarUsuarioOutputPort).buscar(usuario);
        verify(deletarLoginOutputPort).deletar(usuarioDomain.getId());
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioEhNull() {
        assertThrows(UsuarioLoginObrigatorioException.class, () -> {
            deletarLoginUseCase.deletar(null);
        });

        verifyNoInteractions(buscarUsuarioOutputPort, deletarLoginOutputPort);
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioEhVazio() {
        assertThrows(UsuarioLoginObrigatorioException.class, () -> {
            deletarLoginUseCase.deletar("   ");
        });

        verifyNoInteractions(buscarUsuarioOutputPort, deletarLoginOutputPort);
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioNaoEncontrado() {
        String usuario = "inexistente";

        when(buscarUsuarioOutputPort.buscar(usuario))
                .thenReturn(Optional.empty());

        assertThrows(UsuarioNaoEncontradoException.class, () -> {
            deletarLoginUseCase.deletar(usuario);
        });

        verify(buscarUsuarioOutputPort).buscar(usuario);
        verifyNoMoreInteractions(deletarLoginOutputPort);
    }
}
