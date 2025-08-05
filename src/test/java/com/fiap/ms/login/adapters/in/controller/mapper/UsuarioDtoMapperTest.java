package com.fiap.ms.login.adapters.in.controller.mapper;

import com.fiap.ms.login.application.core.domain.UsuarioDomain;
import com.fiap.ms.login.gen.model.UsuarioDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsuarioDtoMapperTest {

    private final UsuarioDtoMapper mapper = UsuarioDtoMapper.INSTANCE;

    @Test
    void testToLogin() {
        UsuarioDto dto = new UsuarioDto();
        dto.setUsuario("usuarioTeste");
        dto.setSenha("senhaTeste");
        dto.setDocumento("12345678900");
        dto.setUsuario("CLIENTE");

        UsuarioDomain domain = mapper.toLogin(dto);

        assertThat(domain).isNotNull();
        assertThat(domain.getUsuario()).isEqualTo(dto.getUsuario());
        assertThat(domain.getSenha()).isEqualTo(dto.getSenha());
        assertThat(domain.getDocumento()).isEqualTo(dto.getDocumento());

        assertThat(domain.getId()).isNull();
        assertThat(domain.getTipoUsuario()).isNull();
        assertThat(domain.getStatusUsuario()).isNull();
    }
}
