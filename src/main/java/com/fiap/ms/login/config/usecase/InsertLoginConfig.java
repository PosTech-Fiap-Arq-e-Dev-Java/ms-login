package com.fiap.ms.login.config.usecase;

import com.fiap.ms.login.application.core.InsertLoginUseCase;
import com.fiap.ms.login.application.ports.out.InsertLoginOutputPort;
import com.fiap.ms.login.application.ports.out.GetLoginOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertLoginConfig {

    @Bean
    public InsertLoginUseCase authRegisterUseCase(InsertLoginOutputPort insertLoginOutputPort,
                                                  GetLoginOutputPort getLoginOutputPort){
        return new InsertLoginUseCase(insertLoginOutputPort, getLoginOutputPort);
    }
}
