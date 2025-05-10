package com.fiap.ms.login.application.core.domain;

public class Login {

    private Integer id;
    private String login;
    private String senha;
    private String cpf;

    public Login(){
    }

    public Login(Integer id, String login, String senha, String cpf) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
