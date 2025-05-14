package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.LoginDomain;
import com.fiap.ms.login.application.core.domain.enums.StatusUsuarioEnum;
import com.fiap.ms.login.application.core.domain.enums.TipoUsuarioEnum;
import com.fiap.ms.login.application.core.domain.exception.DocumentoInvalidoException;
import com.fiap.ms.login.application.core.domain.exception.UserAlreadyExistsException;
import com.fiap.ms.login.application.ports.in.InsertLoginInputPort;
import com.fiap.ms.login.application.ports.in.ValidadorDocumentoInputPort;
import com.fiap.ms.login.application.ports.out.InsertLoginOutputPort;
import com.fiap.ms.login.application.ports.out.GetLoginOutputPort;

public class InsertLoginUseCase implements InsertLoginInputPort {

    private final InsertLoginOutputPort insertLoginOutputPort;
    private final GetLoginOutputPort getLoginOutputPort;
    private final ValidadorDocumentoInputPort validadorDocumentoInputPort;


    public InsertLoginUseCase(InsertLoginOutputPort insertLoginOutputPort,
                              GetLoginOutputPort getLoginOutputPort,
                              ValidadorDocumentoInputPort validadorDocumentoInputPort) {
        this.insertLoginOutputPort = insertLoginOutputPort;
        this.getLoginOutputPort = getLoginOutputPort;
        this.validadorDocumentoInputPort = validadorDocumentoInputPort;
    }

    @Override
    public void insert(LoginDomain customer) {
        getLoginOutputPort.findByUsuarioOrDocumento(customer.getUsuario(), customer.getDocumento())
                .ifPresent(login -> {
                    throw new UserAlreadyExistsException();
                });

        if(!validadorDocumentoInputPort.isValido(customer.getDocumento())){
            throw new DocumentoInvalidoException(customer.getDocumento());
        };

        if(validadorDocumentoInputPort.tipoDocumento(customer.getDocumento()).equals(TipoUsuarioEnum.CLIENTE.getDescricao())){
            customer.setTipoUsuario(TipoUsuarioEnum.CLIENTE);
        } else if(validadorDocumentoInputPort.tipoDocumento(customer.getDocumento()).equals(TipoUsuarioEnum.RESTAURANTE.getDescricao())) {
            customer.setTipoUsuario(TipoUsuarioEnum.RESTAURANTE);
        }

        customer.setStatusUsuario(StatusUsuarioEnum.ATIVO);
        insertLoginOutputPort.insert(customer);
    }
}
