package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.enums.TipoUsuarioEnum;
import com.fiap.ms.login.application.ports.in.ValidadorDocumentoInputPort;
import com.fiap.ms.login.common.utils.CNPJValidator;
import com.fiap.ms.login.common.utils.CPFValidator;

public class ValidadorDocumentoUsecase implements ValidadorDocumentoInputPort {

    @Override
    public boolean isValido(String numero) {
        if (numero.length() == 11) {
            return CPFValidator.isValid(numero);
        } else if (numero.length() == 14) {
            return CNPJValidator.isValid(numero);
        }
        return false;
    }

    @Override
    public String tipoDocumento(String numero) {
        if (numero.length() == 11) {
            return TipoUsuarioEnum.CLIENTE.getDescricao();
        } else if (numero.length() == 14) {
            return TipoUsuarioEnum.RESTAURANTE.getDescricao();
        }
        return "Tipo de documento desconhecido";
    }
}
