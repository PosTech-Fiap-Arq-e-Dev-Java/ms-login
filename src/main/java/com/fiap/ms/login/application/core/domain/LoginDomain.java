package com.fiap.ms.login.application.core.domain;

import com.fiap.ms.login.application.core.domain.enums.StatusUsuarioEnum;
import com.fiap.ms.login.application.core.domain.enums.TipoUsuarioEnum;

public class LoginDomain {

    private Integer id;
    private String usuario;
    private String senha;
    private String documento;
    private TipoUsuarioEnum tipoUsuarioEnum;
    private StatusUsuarioEnum statusUsuarioEnum;

    public LoginDomain(){
    }

    public LoginDomain(Integer id, String usuario, String senha, String documento, TipoUsuarioEnum tipoUsuarioEnum, StatusUsuarioEnum statusUsuarioEnum) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.documento = documento;
        this.tipoUsuarioEnum = tipoUsuarioEnum;
        this.statusUsuarioEnum = statusUsuarioEnum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public TipoUsuarioEnum getTipoUsuario() {
        return tipoUsuarioEnum;
    }

    public void setTipoUsuario(TipoUsuarioEnum tipoUsuarioEnum) {
        this.tipoUsuarioEnum = tipoUsuarioEnum;
    }

    public StatusUsuarioEnum getStatusUsuario() {
        return statusUsuarioEnum;
    }

    public void setStatusUsuario(StatusUsuarioEnum statusUsuarioEnum) {
        this.statusUsuarioEnum = statusUsuarioEnum;
    }
}
