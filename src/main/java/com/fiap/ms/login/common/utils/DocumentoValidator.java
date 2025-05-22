package com.fiap.ms.login.common.utils;

public class DocumentoValidator {

    public static boolean isValid(String documento) {
        if (documento.length() == 11) {
            return CPFValidador.isValido(documento);
        } else if (documento.length() == 14) {
            return CNPJValidador.isValido(documento);
        }
        return false;
    }
}
