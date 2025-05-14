package com.fiap.ms.login.config.usecase;

import com.fiap.ms.login.application.core.AuthLoginUseCase;
import com.fiap.ms.login.application.ports.out.GetLoginOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthLoginConfig {

    @Bean
    public AuthLoginUseCase authLoginUseCase(GetLoginOutputPort getLoginOutputPort) {
        return new AuthLoginUseCase(getLoginOutputPort);
    }
}
