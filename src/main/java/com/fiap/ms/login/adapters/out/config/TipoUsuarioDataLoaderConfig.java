package com.fiap.ms.login.adapters.out.config;

import com.fiap.ms.login.adapters.out.repository.TipoUsuarioRepository;
import com.fiap.ms.login.adapters.out.repository.entity.TipoUsuarioEntity;
import com.fiap.ms.login.application.core.domain.enums.TipoUsuarioEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TipoUsuarioDataLoaderConfig {

    @Bean
    public CommandLineRunner loadTipoUsuarios(TipoUsuarioRepository repository) {
        return args -> {
            List<TipoUsuarioEntity> toSave = new ArrayList<>();
            for (TipoUsuarioEnum tipo : TipoUsuarioEnum.values()) {
                if (!repository.existsById((long) tipo.getId())) {
                    toSave.add(new TipoUsuarioEntity((long) tipo.getId(), tipo.getDescricao()));
                }
            }
            if (!toSave.isEmpty()) {
                repository.saveAll(toSave);
                System.out.println("Tipos de Usuario inseridos: " + toSave.size());
            }
        };
    }
}

