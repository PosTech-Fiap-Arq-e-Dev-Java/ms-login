package com.fiap.ms.login.config.usecase;

import com.fiap.ms.login.application.core.AutenticarLoginUseCase;
import com.fiap.ms.login.application.ports.out.BuscarUsuarioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutenticarLoginConfig {

    @Bean
    public AutenticarLoginUseCase autenticarLoginUseCase(BuscarUsuarioOutputPort buscarUsuarioOutputPort) {
        return new AutenticarLoginUseCase(buscarUsuarioOutputPort);
    }
}
