package com.fiap.ms.login.application.core.domain;

import com.fiap.ms.login.application.core.domain.enums.TipoUsuarioEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutenticacaoLoginDomainTest {

    @Test
    void deveCriarObjetoComConstrutor() {
        String usuario = "usuarioTeste";
        TipoUsuarioEnum tipo = TipoUsuarioEnum.CLIENTE;

        AutenticacaoLoginDomain domain = new AutenticacaoLoginDomain(usuario, tipo);

        assertEquals(usuario, domain.getUsuario());
        assertEquals(tipo, domain.getTipoUsuarioEnum());
    }

    @Test
    void devePermitirSettersEGetters() {
        AutenticacaoLoginDomain domain = new AutenticacaoLoginDomain();

        domain.setUsuario("usuarioTeste2");
        domain.setTipoUsuarioEnum(TipoUsuarioEnum.RESTAURANTE);

        assertEquals("usuarioTeste2", domain.getUsuario());
        assertEquals(TipoUsuarioEnum.RESTAURANTE, domain.getTipoUsuarioEnum());
    }
}

