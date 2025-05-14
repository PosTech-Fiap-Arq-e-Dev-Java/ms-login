package com.fiap.ms.login.config.usecase;

import com.fiap.ms.login.application.core.PatchLoginUseCase;
import com.fiap.ms.login.application.ports.out.GetLoginOutputPort;
import com.fiap.ms.login.application.ports.out.PatchLoginOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatchLoginConfig {

    @Bean
    public PatchLoginUseCase patchLoginUseCase(GetLoginOutputPort getLoginOutputPort,
                                                PatchLoginOutputPort patchLoginOutputPort
    ) {
        return new PatchLoginUseCase(patchLoginOutputPort, getLoginOutputPort);
    }
}
