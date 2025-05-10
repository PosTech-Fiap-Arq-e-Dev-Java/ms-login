package com.fiap.ms.login.config.usecase;

import com.fiap.ms.login.application.core.DeleteLoginUseCase;
import com.fiap.ms.login.application.ports.out.DeleteLoginOutputPort;
import com.fiap.ms.login.application.ports.out.GetLoginOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteLoginConfig {

    @Bean
    public DeleteLoginUseCase deleteLoginUseCase(GetLoginOutputPort getLoginOutputPort,
                              DeleteLoginOutputPort deleteLoginOutputPort
    ) {
       return new DeleteLoginUseCase(getLoginOutputPort, deleteLoginOutputPort);
    }
}
