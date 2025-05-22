package com.fiap.ms.login.config.usecase;

import com.fiap.ms.login.application.core.DeletarLoginUseCase;
import com.fiap.ms.login.application.ports.out.DeletarLoginOutputPort;
import com.fiap.ms.login.application.ports.out.BuscarUsuarioOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletarLoginConfig {

    @Bean
    public DeletarLoginUseCase deletarLoginUseCase(BuscarUsuarioOutputPort buscarUsuarioOutputPort,
                                                  DeletarLoginOutputPort deletarLoginOutputPort
    ) {
       return new DeletarLoginUseCase(buscarUsuarioOutputPort, deletarLoginOutputPort);
    }
}
