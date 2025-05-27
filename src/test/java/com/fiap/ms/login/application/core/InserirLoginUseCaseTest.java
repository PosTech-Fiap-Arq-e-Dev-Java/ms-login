package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.UsuarioDomain;
import com.fiap.ms.login.application.core.domain.enums.StatusUsuarioEnum;
import com.fiap.ms.login.application.core.domain.enums.TipoUsuarioEnum;
import com.fiap.ms.login.application.core.domain.exception.DocumentoInvalidoException;
import com.fiap.ms.login.application.core.domain.exception.UsuarioJaExisteException;
import com.fiap.ms.login.application.handler.LoginValidatorHandler;
import com.fiap.ms.login.application.ports.in.ValidadorDocumentoInputPort;
import com.fiap.ms.login.application.ports.out.BuscarUsuarioOutputPort;
import com.fiap.ms.login.application.ports.out.InserirLoginOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class InserirLoginUseCaseTest {

    private InserirLoginOutputPort inserirLoginOutputPort;
    private BuscarUsuarioOutputPort buscarUsuarioOutputPort;
    private LoginValidatorHandler loginValidatorHandler;
    private ValidadorDocumentoInputPort validadorDocumentoInputPort;
    private InserirLoginUseCase inserirLoginUseCase;

    @BeforeEach
    void setUp() {
        inserirLoginOutputPort = mock(InserirLoginOutputPort.class);
        buscarUsuarioOutputPort = mock(BuscarUsuarioOutputPort.class);
        loginValidatorHandler = mock(LoginValidatorHandler.class);
        validadorDocumentoInputPort = mock(ValidadorDocumentoInputPort.class);

        inserirLoginUseCase = new InserirLoginUseCase(
                inserirLoginOutputPort,
                buscarUsuarioOutputPort,
                loginValidatorHandler,
                validadorDocumentoInputPort
        );
    }

    @Test
    void deveInserirClienteComSucesso() {
        UsuarioDomain usuario = new UsuarioDomain();
        usuario.setUsuario("cliente123");
        usuario.setDocumento("12345678901");

        when(buscarUsuarioOutputPort.buscarUsuarioOuDocumento(usuario.getUsuario(), usuario.getDocumento()))
                .thenReturn(Optional.empty());

        when(validadorDocumentoInputPort.isValido(usuario.getDocumento()))
                .thenReturn(true);

        when(validadorDocumentoInputPort.tipoDocumento(usuario.getDocumento()))
                .thenReturn(TipoUsuarioEnum.CLIENTE.getDescricao());

        inserirLoginUseCase.inserir(usuario);

        verify(loginValidatorHandler).validarCamposObrigatoriosLogin(usuario);
        verify(inserirLoginOutputPort).inserir(usuario);

        assertEquals(StatusUsuarioEnum.ATIVO, usuario.getStatusUsuario());
        assertEquals(TipoUsuarioEnum.CLIENTE, usuario.getTipoUsuario());
    }

    @Test
    void deveInserirRestauranteComSucesso() {
        UsuarioDomain usuario = new UsuarioDomain();
        usuario.setUsuario("restaurante123");
        usuario.setDocumento("12345678000199");

        when(buscarUsuarioOutputPort.buscarUsuarioOuDocumento(usuario.getUsuario(), usuario.getDocumento()))
                .thenReturn(Optional.empty());

        when(validadorDocumentoInputPort.isValido(usuario.getDocumento()))
                .thenReturn(true);

        when(validadorDocumentoInputPort.tipoDocumento(usuario.getDocumento()))
                .thenReturn(TipoUsuarioEnum.RESTAURANTE.getDescricao());

        inserirLoginUseCase.inserir(usuario);

        verify(loginValidatorHandler).validarCamposObrigatoriosLogin(usuario);
        verify(inserirLoginOutputPort).inserir(usuario);

        assertEquals(StatusUsuarioEnum.ATIVO, usuario.getStatusUsuario());
        assertEquals(TipoUsuarioEnum.RESTAURANTE, usuario.getTipoUsuario());
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioOuDocumentoJaExiste() {
        UsuarioDomain usuario = new UsuarioDomain();
        usuario.setUsuario("existente");
        usuario.setDocumento("12345678901");

        when(buscarUsuarioOutputPort.buscarUsuarioOuDocumento(usuario.getUsuario(), usuario.getDocumento()))
                .thenReturn(Optional.of(new UsuarioDomain()));

        assertThrows(UsuarioJaExisteException.class, () -> {
            inserirLoginUseCase.inserir(usuario);
        });

        verify(loginValidatorHandler).validarCamposObrigatoriosLogin(usuario);
        verifyNoMoreInteractions(inserirLoginOutputPort);
    }

    @Test
    void deveLancarExcecaoQuandoDocumentoInvalido() {
        UsuarioDomain usuario = new UsuarioDomain();
        usuario.setUsuario("user123");
        usuario.setDocumento("12345678901");

        when(buscarUsuarioOutputPort.buscarUsuarioOuDocumento(usuario.getUsuario(), usuario.getDocumento()))
                .thenReturn(Optional.empty());

        when(validadorDocumentoInputPort.isValido(usuario.getDocumento()))
                .thenReturn(false);

        assertThrows(DocumentoInvalidoException.class, () -> {
            inserirLoginUseCase.inserir(usuario);
        });

        verify(loginValidatorHandler).validarCamposObrigatoriosLogin(usuario);
        verifyNoMoreInteractions(inserirLoginOutputPort);
    }
}
