package com.fiap.ms.login.adapters.out.repository;

import com.fiap.ms.login.adapters.out.repository.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {

    Optional<LoginEntity> findLoginByUsuario(String usuario);

    Optional<LoginEntity> findByUsuarioOrDocumento(String usuario, String documento);

    @Query("SELECT l.usuario, l.statusUsuario FROM tb_login l WHERE l.usuario = :usuario")
    Optional<LoginEntity> findUsuarioStatusByUsuario(@Param("usuario") String usuario);

}
