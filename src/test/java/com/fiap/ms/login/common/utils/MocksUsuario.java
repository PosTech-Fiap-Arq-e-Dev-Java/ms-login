package com.fiap.ms.login.common.utils;

import com.fiap.ms.login.application.core.domain.UsuarioDomain;
import com.fiap.ms.login.application.core.domain.enums.StatusUsuarioEnum;
import com.fiap.ms.login.application.core.domain.enums.TipoUsuarioEnum;
import com.fiap.ms.login.gen.model.AtualizarSenhaDto;
import com.fiap.ms.login.gen.model.AutenticacaoUsuarioDto;
import com.fiap.ms.login.gen.model.UsuarioDto;

public class MocksUsuario {

    public static UsuarioDomain getUsuarioDomain() {
        UsuarioDomain usuarioDomain = new UsuarioDomain();
        usuarioDomain.setId(1);
        usuarioDomain.setUsuario("usuario");
        usuarioDomain.setSenha("senha");
        usuarioDomain.setDocumento("53720548082");
        usuarioDomain.setTipoUsuario(TipoUsuarioEnum.CLIENTE);
        usuarioDomain.setStatusUsuario(StatusUsuarioEnum.ATIVO);
        return usuarioDomain;
    }

    public static UsuarioDto getUsuarioDto() {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setUsuario("user123");
        usuarioDto.setDocumento("12345678901");
        usuarioDto.setSenha("senha123");
        return usuarioDto;
    }

    public static AtualizarSenhaDto getAtualizarSenhaDto() {
        AtualizarSenhaDto atualizarSenhaDto = new AtualizarSenhaDto();
        atualizarSenhaDto.setSenhaAntiga("senhaAntiga");
        atualizarSenhaDto.setSenhaNova("senhaNova");
        return atualizarSenhaDto;
    }

    public static AutenticacaoUsuarioDto getAutenticacaoUsuarioDto() {
        AutenticacaoUsuarioDto autenticacaoUsuarioDto = new AutenticacaoUsuarioDto();
        autenticacaoUsuarioDto.setUsuario("user123");
        autenticacaoUsuarioDto.setSenha("senha123");
        return autenticacaoUsuarioDto;
    }
}
