package com.fiap.ms.login.common.utils;

import com.fiap.ms.login.application.core.domain.exception.CNPJInvalidoException;

public class CNPJValidator {

    public static boolean isValid(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]", "");

        if (cnpj.length() != 14 || cnpj.matches("(\\d)\\1{13}")) {
            throw new CNPJInvalidoException(cnpj);
        }

        int digito1 = calcularDigitoVerificador(cnpj, 12, new int[] {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2});
        int digito2 = calcularDigitoVerificador(cnpj, 13, new int[] {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2});

        if (cnpj.charAt(12) != digito1 + '0' || cnpj.charAt(13) != digito2 + '0') {
            throw new CNPJInvalidoException(cnpj);
        }

        return true;
    }

    private static int calcularDigitoVerificador(String cnpj, int pesoBase, int[] pesos) {
        int soma = 0;
        for (int i = 0; i < pesoBase; i++) {
            soma += (cnpj.charAt(i) - '0') * pesos[i];
        }
        int resto = soma % 11;
        return resto < 2 ? 0 : 11 - resto;
    }
}