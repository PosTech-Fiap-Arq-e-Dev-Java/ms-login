package com.fiap.ms.login.common.utils;

import com.fiap.ms.login.application.core.domain.exception.CPFCNPJInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DocumentoValidatorTest {

    @Test
    void deveValidarCPFValido() {
        String cpfValido = "52998224725";
        assertTrue(DocumentoValidator.isValid(cpfValido));
    }

    @Test
    void deveValidarCNPJValido() {
        String cnpjValido = "11222333000181";
        assertTrue(DocumentoValidator.isValid(cnpjValido));
    }

    @Test
    void deveLancarExcecaoParaCPFInvalido() {
        String cpfInvalido = "12345678900";

        assertThrows(CPFCNPJInvalidoException.class, () -> {
            DocumentoValidator.isValid(cpfInvalido);
        });
    }

    @Test
    void deveLancarExcecaoParaCNPJInvalido() {
        String cnpjInvalido = "12345678000199";

        assertThrows(CPFCNPJInvalidoException.class, () -> {
            DocumentoValidator.isValid(cnpjInvalido);
        });
    }

    @Test
    void deveRetornarFalseParaDocumentoComTamanhoInvalido() {
        String documentoCurto = "12345";
        assertFalse(DocumentoValidator.isValid(documentoCurto));
    }
}
