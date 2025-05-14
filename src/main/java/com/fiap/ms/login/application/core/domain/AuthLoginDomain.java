package com.fiap.ms.login.application.core.domain;

import com.fiap.ms.login.application.core.domain.enums.TipoUsuarioEnum;

public class AuthLoginDomain {

    private String usuario;
    private TipoUsuarioEnum tipoUsuarioEnum;

    public AuthLoginDomain(){
    }

    public AuthLoginDomain(String usuario, TipoUsuarioEnum tipoUsuarioEnum) {
        this.usuario = usuario;
        this.tipoUsuarioEnum = tipoUsuarioEnum;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public TipoUsuarioEnum getTipoUsuarioEnum() {
        return tipoUsuarioEnum;
    }

    public void setTipoUsuarioEnum(TipoUsuarioEnum tipoUsuarioEnum) {
        this.tipoUsuarioEnum = tipoUsuarioEnum;
    }
}
