package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.exception.CPFCNPJInvalidoException;
import com.fiap.ms.login.common.utils.CNPJValidador;
import com.fiap.ms.login.common.utils.CPFValidador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidadorDocumentoUsecaseTest {

    @Test
    void deveValidarCPFValido() {
        String cpfValido = "52998224725";
        assertTrue(CPFValidador.isValido(cpfValido));
    }

    @Test
    void deveValidarCNPJValido() {
        String cnpjValido = "11222333000181";
        assertTrue(CNPJValidador.isValido(cnpjValido));
    }

    @Test
    void deveLancarExcecaoParaCPFInvalido() {
        String cpfInvalido = "12345678900";
        assertThrows(CPFCNPJInvalidoException.class, () -> {
            CPFValidador.isValido(cpfInvalido);
        });
    }

    @Test
    void deveLancarExcecaoParaCNPJInvalido() {
        String cnpjInvalido = "12345678000199";
        assertThrows(CPFCNPJInvalidoException.class, () -> {
            CNPJValidador.isValido(cnpjInvalido);
        });
    }
}
