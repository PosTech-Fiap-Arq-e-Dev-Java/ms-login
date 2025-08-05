package com.fiap.ms.login.adapters.in.controller.mapper;

import com.fiap.ms.login.application.core.domain.AtualizarSenhaDomain;
import com.fiap.ms.login.gen.model.AtualizarSenhaDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AtualizarSenhaDtoMapperTest {

    private final AtualizarSenhaDtoMapper mapper = AtualizarSenhaDtoMapper.INSTANCE;

    @Test
    void testToAtualizarSenhaDomain() {
        AtualizarSenhaDto dto = new AtualizarSenhaDto();
        dto.setSenhaAntiga("senhaAntiga123");
        dto.setSenhaNova("senhaNova456");

        AtualizarSenhaDomain domain = mapper.toAtualizarSenhaDomain(dto);

        assertThat(domain).isNotNull();
        assertThat(domain.getSenhaAntiga()).isEqualTo(dto.getSenhaAntiga());
        assertThat(domain.getSenhaNova()).isEqualTo(dto.getSenhaNova());
    }
}

