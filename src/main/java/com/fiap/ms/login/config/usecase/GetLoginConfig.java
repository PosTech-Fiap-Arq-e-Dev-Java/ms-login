package com.fiap.ms.login.config.usecase;

import com.fiap.ms.login.application.core.GetLoginUseCase;
import com.fiap.ms.login.application.ports.out.GetLoginOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetLoginConfig {

    @Bean
    public GetLoginUseCase getLoginUseCase(GetLoginOutputPort getLoginOutputPort) {
        return new GetLoginUseCase(getLoginOutputPort);
    }
}
