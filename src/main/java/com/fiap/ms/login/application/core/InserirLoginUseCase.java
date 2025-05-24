package com.fiap.ms.login.application.core;

import com.fiap.ms.login.application.core.domain.UsuarioDomain;
import com.fiap.ms.login.application.core.domain.enums.StatusUsuarioEnum;
import com.fiap.ms.login.application.core.domain.enums.TipoUsuarioEnum;
import com.fiap.ms.login.application.core.domain.exception.DocumentoInvalidoException;
import com.fiap.ms.login.application.core.domain.exception.UsuarioJaExisteException;
import com.fiap.ms.login.application.handler.LoginValidatorHandler;
import com.fiap.ms.login.application.ports.in.InserirLoginInputPort;
import com.fiap.ms.login.application.ports.in.ValidadorDocumentoInputPort;
import com.fiap.ms.login.application.ports.out.InsertLoginOutputPort;
import com.fiap.ms.login.application.ports.out.BuscarUsuarioOutputPort;

public class InserirLoginUseCase implements InserirLoginInputPort {

    private final InsertLoginOutputPort insertLoginOutputPort;
    private final BuscarUsuarioOutputPort buscarUsuarioOutputPort;
    private final LoginValidatorHandler loginValidatorHandler;
    private final ValidadorDocumentoInputPort validadorDocumentoInputPort;


    public InserirLoginUseCase(InsertLoginOutputPort insertLoginOutputPort,
                               BuscarUsuarioOutputPort buscarUsuarioOutputPort, LoginValidatorHandler loginValidatorHandler,
                               ValidadorDocumentoInputPort validadorDocumentoInputPort) {
        this.insertLoginOutputPort = insertLoginOutputPort;
        this.buscarUsuarioOutputPort = buscarUsuarioOutputPort;
        this.loginValidatorHandler = loginValidatorHandler;
        this.validadorDocumentoInputPort = validadorDocumentoInputPort;
    }

    @Override
    public void inserir(UsuarioDomain customer) {
        loginValidatorHandler.validarCamposObrigatoriosLogin(customer);

        buscarUsuarioOutputPort.buscarUsuarioOuDocumento(customer.getUsuario(), customer.getDocumento())
                .ifPresent(login -> {
                    throw new UsuarioJaExisteException();
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
