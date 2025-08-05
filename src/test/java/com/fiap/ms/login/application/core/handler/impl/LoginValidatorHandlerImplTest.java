package com.fiap.ms.login.application.core.handler.impl;

import com.fiap.ms.login.application.core.domain.UsuarioDomain;
import com.fiap.ms.login.application.core.domain.exception.CampoObrigatorioException;
import com.fiap.ms.login.application.handler.impl.LoginValidatorHandlerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginValidatorHandlerImplTest {

    private LoginValidatorHandlerImpl loginValidatorHandler;

    @BeforeEach
    void setUp() {
        loginValidatorHandler = new LoginValidatorHandlerImpl();
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioDomainForNulo() {
        assertThrows(CampoObrigatorioException.class, () -> loginValidatorHandler.validarCamposObrigatoriosLogin(null));
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioEstiverVazio() {
        UsuarioDomain usuario = new UsuarioDomain();
        usuario.setUsuario("");
        usuario.setDocumento("123456789");
        usuario.setSenha("senha123");

        assertThrows(CampoObrigatorioException.class, () -> loginValidatorHandler.validarCamposObrigatoriosLogin(usuario));
    }

    @Test
    void deveLancarExcecaoQuandoDocumentoEstiverVazio() {
        UsuarioDomain usuario = new UsuarioDomain();
        usuario.setUsuario("usuarioTeste");
        usuario.setDocumento("");
        usuario.setSenha("senha123");

        assertThrows(CampoObrigatorioException.class, () -> loginValidatorHandler.validarCamposObrigatoriosLogin(usuario));
    }

    @Test
    void deveLancarExcecaoQuandoSenhaEstiverVazia() {
        UsuarioDomain usuario = new UsuarioDomain();
        usuario.setUsuario("usuarioTeste");
        usuario.setDocumento("123456789");
        usuario.setSenha("");

        assertThrows(CampoObrigatorioException.class, () -> loginValidatorHandler.validarCamposObrigatoriosLogin(usuario));
    }

    @Test
    void naoDeveLancarExcecaoQuandoTodosCamposEstiveremPreenchidos() {
        UsuarioDomain usuario = new UsuarioDomain();
        usuario.setUsuario("usuarioTeste");
        usuario.setDocumento("123456789");
        usuario.setSenha("senha123");

        assertDoesNotThrow(() -> loginValidatorHandler.validarCamposObrigatoriosLogin(usuario));
    }
}

