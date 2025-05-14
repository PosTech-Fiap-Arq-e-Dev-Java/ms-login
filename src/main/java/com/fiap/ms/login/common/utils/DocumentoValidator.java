package com.fiap.ms.login.common.utils;

public class DocumentoValidator {

    public static boolean isValid(String documento) {
        if (documento.length() == 11) {
            return CPFValidator.isValid(documento);
        } else if (documento.length() == 14) {
            return CNPJValidator.isValid(documento);
        }
        return false;
    }
}
