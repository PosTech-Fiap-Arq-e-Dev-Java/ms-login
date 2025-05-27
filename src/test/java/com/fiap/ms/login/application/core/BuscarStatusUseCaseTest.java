package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.UsuarioDomain;
import com.fiap.ms.login.application.core.domain.exception.UsuarioNaoEncontradoException;
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

public class BuscarStatusUseCaseTest {

    private BuscarUsuarioOutputPort buscarUsuarioOutputPort;
    private BuscarStatusUseCase buscarStatusUseCase;

    @BeforeEach
    void setUp() {
        buscarUsuarioOutputPort = mock(BuscarUsuarioOutputPort.class);
        buscarStatusUseCase = new BuscarStatusUseCase(buscarUsuarioOutputPort);
    }

    @Test
    void deveRetornarUsuarioQuandoEncontrado() {
        String usuario = "user123";
        UsuarioDomain usuarioDomain = new UsuarioDomain();
        usuarioDomain.setUsuario(usuario);

        when(buscarUsuarioOutputPort.buscar(usuario)).thenReturn(Optional.of(usuarioDomain));

        UsuarioDomain resultado = buscarStatusUseCase.buscar(usuario);

        assertNotNull(resultado);
        assertEquals(usuario, resultado.getUsuario());
        verify(buscarUsuarioOutputPort).buscar(usuario);
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioNaoEncontrado() {
        String usuario = "user123";

        when(buscarUsuarioOutputPort.buscar(usuario)).thenReturn(Optional.empty());

        assertThrows(UsuarioNaoEncontradoException.class, () -> {
            buscarStatusUseCase.buscar(usuario);
        });

        verify(buscarUsuarioOutputPort).buscar(usuario);
    }
}
