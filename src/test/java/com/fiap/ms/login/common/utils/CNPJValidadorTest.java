package com.fiap.ms.login.common.utils;

import com.fiap.ms.login.application.core.domain.exception.CPFCNPJInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CNPJValidadorTest {

    @Test
    void deveValidarCNPJCorreto() {
        String cnpjValido = "11222333000181";

        assertTrue(CNPJValidador.isValido(cnpjValido));
    }

    @Test
    void deveLancarExcecaoParaCNPJInvalido() {
        String cnpjInvalido = "11222333000182";

        assertThrows(CPFCNPJInvalidoException.class, () -> {
            CNPJValidador.isValido(cnpjInvalido);
        });
    }

    @Test
    void deveLancarExcecaoParaCNPJRepetido() {
        String cnpjRepetido = "11111111111111";

        assertThrows(CPFCNPJInvalidoException.class, () -> {
            CNPJValidador.isValido(cnpjRepetido);
        });
    }

    @Test
    void deveLancarExcecaoParaCNPJComTamanhoInvalido() {
        String cnpjCurto = "123456";

        assertThrows(CPFCNPJInvalidoException.class, () -> {
            CNPJValidador.isValido(cnpjCurto);
        });
    }
}
