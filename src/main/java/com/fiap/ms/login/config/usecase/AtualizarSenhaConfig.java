package com.fiap.ms.login.config.usecase;

import com.fiap.ms.login.application.core.AtualizarSenhaUseCase;
import com.fiap.ms.login.application.handler.SenhaValidadorHandler;
import com.fiap.ms.login.application.ports.out.BuscarUsuarioOutputPort;
import com.fiap.ms.login.application.ports.out.AtualizarSenhaOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtualizarSenhaConfig {

    @Bean
    public AtualizarSenhaUseCase atualizarSenhaUseCase(BuscarUsuarioOutputPort buscarUsuarioOutputPort,
                                                   AtualizarSenhaOutputPort atualizarSenhaOutputPort,
                                                   SenhaValidadorHandler senhaValidadorHandler) {
        return new AtualizarSenhaUseCase(atualizarSenhaOutputPort, buscarUsuarioOutputPort, senhaValidadorHandler);
    }
}
