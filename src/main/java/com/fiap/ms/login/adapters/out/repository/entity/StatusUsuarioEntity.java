package com.fiap.ms.login.adapters.out.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_status_usuario")
public class StatusUsuarioEntity {

    @Id
    private Long id;
    private String status;
}
