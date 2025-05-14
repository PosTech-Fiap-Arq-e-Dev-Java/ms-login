package com.fiap.ms.login.application.core.domain;

public class UpdatePasswordDomain {

    private String senhaAntiga;
    private String senhaNova;

    public UpdatePasswordDomain(){
    }

    public UpdatePasswordDomain(String senhaAntiga, String senhaNova) {
        this.senhaAntiga = senhaAntiga;
        this.senhaNova = senhaNova;
    }

    public String getSenhaAntiga() {
        return senhaAntiga;
    }

    public void setSenhaAntiga(String senhaAntiga) {
        this.senhaAntiga = senhaAntiga;
    }

    public String getSenhaNova() {
        return senhaNova;
    }

    public void setSenhaNova(String senhaNova) {
        this.senhaNova = senhaNova;
    }
}
