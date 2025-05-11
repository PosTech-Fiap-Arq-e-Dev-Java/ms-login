package com.fiap.ms.login.config.usecase;

import com.fiap.ms.login.application.core.AuthRegisterUseCase;
import com.fiap.ms.login.application.ports.out.AuthRegisterOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthRegisterConfig {

    @Bean
    public AuthRegisterUseCase authRegisterUseCase(AuthRegisterOutputPort authRegisterOutputPort){
        return new AuthRegisterUseCase(authRegisterOutputPort);
    }
}
