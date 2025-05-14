package com.fiap.ms.login.application.ports.in;

public interface ValidadorDocumentoInputPort {

    boolean isValido(String documento);
    String tipoDocumento(String documento);
}
