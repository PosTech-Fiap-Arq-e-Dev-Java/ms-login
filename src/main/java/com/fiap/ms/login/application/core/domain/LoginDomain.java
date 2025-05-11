package com.fiap.ms.login.application.core.domain;

public class LoginDomain {

    private Integer id;
    private String usuario;
    private String senha;
    private String cpf;

    public LoginDomain(){
    }

    public LoginDomain(Integer id, String usuario, String senha, String cpf) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
