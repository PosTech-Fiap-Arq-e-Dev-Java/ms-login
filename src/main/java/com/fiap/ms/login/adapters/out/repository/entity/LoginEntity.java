package com.fiap.ms.login.adapters.out.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_login")
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String usuario;

    private String senha;

    @Column(unique = true)
    private String documento;

    @ManyToOne
    @JoinColumn(name = "tb_tipo_usuario_id")
    private TipoUsuarioEntity tipoUsuario;

    @ManyToOne
    @JoinColumn(name = "tb_status_usuario_id")
    private StatusUsuarioEntity statusUsuario;

}
