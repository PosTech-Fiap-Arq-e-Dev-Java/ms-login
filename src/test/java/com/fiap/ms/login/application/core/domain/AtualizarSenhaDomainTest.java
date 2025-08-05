package com.fiap.ms.login.application.core.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtualizarSenhaDomainTest {

    @Test
    void deveCriarObjetoComConstrutorComParametros() {
        String senhaAntiga = "oldPass123";
        String senhaNova = "newPass456";

        AtualizarSenhaDomain domain = new AtualizarSenhaDomain(senhaAntiga, senhaNova);

        assertEquals(senhaAntiga, domain.getSenhaAntiga());
        assertEquals(senhaNova, domain.getSenhaNova());
    }

    @Test
    void devePermitirSettersEGetters() {
        AtualizarSenhaDomain domain = new AtualizarSenhaDomain();

        domain.setSenhaAntiga("oldPass");
        domain.setSenhaNova("newPass");

        assertEquals("oldPass", domain.getSenhaAntiga());
        assertEquals("newPass", domain.getSenhaNova());
    }
}
