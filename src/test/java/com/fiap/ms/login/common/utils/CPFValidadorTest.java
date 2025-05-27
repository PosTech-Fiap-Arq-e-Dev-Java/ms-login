package com.fiap.ms.login.common.utils;

import com.fiap.ms.login.application.core.domain.exception.CPFCNPJInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CPFValidadorTest {

    @Test
    void deveValidarCPFCorreto() {
        String cpfValido = "52998224725";

        assertTrue(CPFValidador.isValido(cpfValido));
    }

    @Test
    void deveLancarExcecaoParaCPFInvalido() {
        String cpfInvalido = "52998224724";

        assertThrows(CPFCNPJInvalidoException.class, () -> {
            CPFValidador.isValido(cpfInvalido);
        });
    }

    @Test
    void deveLancarExcecaoParaCPFRepetido() {
        String cpfRepetido = "11111111111";

        assertThrows(CPFCNPJInvalidoException.class, () -> {
            CPFValidador.isValido(cpfRepetido);
        });
    }

    @Test
    void deveLancarExcecaoParaCPFComTamanhoInvalido() {
        String cpfCurto = "123456";

        assertThrows(CPFCNPJInvalidoException.class, () -> {
            CPFValidador.isValido(cpfCurto);
        });
    }
}
