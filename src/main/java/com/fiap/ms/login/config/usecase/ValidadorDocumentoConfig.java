package com.fiap.ms.login.config.usecase;

import com.fiap.ms.login.application.core.ValidadorDocumentoUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidadorDocumentoConfig {

    @Bean
    public ValidadorDocumentoUsecase validadorDocumentoUsecase() {
        return new ValidadorDocumentoUsecase();
    }
}
