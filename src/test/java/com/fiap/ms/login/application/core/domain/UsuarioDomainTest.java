package com.fiap.ms.login.application.core.domain;

import com.fiap.ms.login.application.core.domain.enums.StatusUsuarioEnum;
import com.fiap.ms.login.application.core.domain.enums.TipoUsuarioEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDomainTest {

    @Test
    void deveCriarObjetoComConstrutorCompleto() {
        Integer id = 10;
        String usuario = "usuarioTeste";
        String senha = "senha123";
        String documento = "12345678900";
        TipoUsuarioEnum tipo = TipoUsuarioEnum.CLIENTE;
        StatusUsuarioEnum status = StatusUsuarioEnum.ATIVO;

        UsuarioDomain domain = new UsuarioDomain(id, usuario, senha, documento, tipo, status);

        assertEquals(id, domain.getId());
        assertEquals(usuario, domain.getUsuario());
        assertEquals(senha, domain.getSenha());
        assertEquals(documento, domain.getDocumento());
        assertEquals(tipo, domain.getTipoUsuario());
        assertEquals(status, domain.getStatusUsuario());
    }

    @Test
    void devePermitirSettersEGetters() {
        UsuarioDomain domain = new UsuarioDomain();

        domain.setId(20);
        domain.setUsuario("usuario2");
        domain.setSenha("senha456");
        domain.setDocumento("09876543211");
        domain.setTipoUsuario(TipoUsuarioEnum.RESTAURANTE);
        domain.setStatusUsuario(StatusUsuarioEnum.INATIVO);

        assertEquals(20, domain.getId());
        assertEquals("usuario2", domain.getUsuario());
        assertEquals("senha456", domain.getSenha());
        assertEquals("09876543211", domain.getDocumento());
        assertEquals(TipoUsuarioEnum.RESTAURANTE, domain.getTipoUsuario());
        assertEquals(StatusUsuarioEnum.INATIVO, domain.getStatusUsuario());
    }
}