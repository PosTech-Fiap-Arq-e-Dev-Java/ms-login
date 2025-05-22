package com.fiap.ms.login.config.usecase;

import com.fiap.ms.login.application.core.InserirLoginUseCase;
import com.fiap.ms.login.application.handler.LoginValidatorHandler;
import com.fiap.ms.login.application.ports.in.ValidadorDocumentoInputPort;
import com.fiap.ms.login.application.ports.out.InserirLoginOutputPort;
import com.fiap.ms.login.application.ports.out.BuscarUsuarioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InserirLoginConfig {

    @Bean
    public InserirLoginUseCase inserirLoginUseCase(InserirLoginOutputPort inserirLoginOutputPort,
                                                   BuscarUsuarioOutputPort buscarUsuarioOutputPort,
                                                   ValidadorDocumentoInputPort validadorDocumentoInputPort,
                                                   LoginValidatorHandler loginValidatorHandler){
        return new InserirLoginUseCase(inserirLoginOutputPort, buscarUsuarioOutputPort, validadorDocumentoInputPort, loginValidatorHandler);
    }
}
