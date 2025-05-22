package com.fiap.ms.login.config.usecase;

import com.fiap.ms.login.application.core.BuscarStatusUseCase;
import com.fiap.ms.login.application.ports.out.BuscarUsuarioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuscarUsuarioConfig {

    @Bean
    public BuscarStatusUseCase buscarStatusUseCase(BuscarUsuarioOutputPort buscarUsuarioOutputPort) {
        return new BuscarStatusUseCase(buscarUsuarioOutputPort);
    }
}
