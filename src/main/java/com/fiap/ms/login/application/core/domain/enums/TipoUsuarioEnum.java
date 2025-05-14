package com.fiap.ms.login.application.core.domain.enums;

public enum TipoUsuarioEnum {

    CLIENTE(1, "CLIENTE"),
    RESTAURANTE(2, "RESTAURANTE");

    private final int id;
    private final String descricao;

    TipoUsuarioEnum(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoUsuarioEnum fromId(int id) {
        for (TipoUsuarioEnum tipo : TipoUsuarioEnum.values()) {
            if (tipo.getId() == id) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Id inválido para TipoUsuario: " + id);
    }

}