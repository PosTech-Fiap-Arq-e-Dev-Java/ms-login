package com.fiap.ms.login.adapters.out.config;

import com.fiap.ms.login.adapters.out.repository.StatusUsuarioRepository;
import com.fiap.ms.login.adapters.out.repository.entity.StatusUsuarioEntity;
import com.fiap.ms.login.application.core.domain.enums.StatusUsuarioEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StatusUsuarioDataLoaderConfig {

    @Bean
    public CommandLineRunner loadStatusUsuarios(StatusUsuarioRepository repository) {
        return args -> {
            List<StatusUsuarioEntity> toSave = new ArrayList<>();
            for (StatusUsuarioEnum status : StatusUsuarioEnum.values()) {
                if (!repository.existsById((long) status.getId())) {
                    toSave.add(new StatusUsuarioEntity((long) status.getId(), status.getStatus()));
                }
            }
            if (!toSave.isEmpty()) {
                repository.saveAll(toSave);
                System.out.println("Status de Usuarios inseridos: " + toSave.size());
            }
        };
    }
}

