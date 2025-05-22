package com.fiap.ms.login.common.utils;

import com.fiap.ms.login.application.core.domain.exception.CPFCNPJInvalidoException;

public class CPFValidador {

    public static boolean isValido(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            throw new CPFCNPJInvalidoException(cpf);
        }

        int digito1 = calcularDigitoVerificador(cpf, 10);
        int digito2 = calcularDigitoVerificador(cpf, 11);

        if (cpf.charAt(9) != digito1 + '0' || cpf.charAt(10) != digito2 + '0') {
            throw new CPFCNPJInvalidoException(cpf);
        }

        return true;
    }

    private static int calcularDigitoVerificador(String cpf, int peso) {
        int soma = 0;
        for (int i = 0; i < peso - 1; i++) {
            soma += (cpf.charAt(i) - '0') * (peso - i);
        }
        int resto = soma % 11;
        return resto < 2 ? 0 : 11 - resto;
    }
}