package com.fiap.ms.login.application.core.domain.enums;

public enum StatusUsuarioEnum {

    ATIVO(1, "ATIVO"),
    INATIVO(2, "INATIVO"),
    BLOQUEADO(3, "BLOQUEADO"),
    PENDENTE(4, "PENDENTE"),
    EXPIRADO(5, "EXPIRADO"),
    SUSPENSO(6, "SUSPENSO"),;

    private final int id;
    private final String status;

    StatusUsuarioEnum(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public static StatusUsuarioEnum fromId(int id) {
        for (StatusUsuarioEnum tipo : StatusUsuarioEnum.values()) {
            if (tipo.getId() == id) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Id inválido para TipoUsuario: " + id);
    }

}