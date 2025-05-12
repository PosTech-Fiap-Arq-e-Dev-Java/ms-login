package com.fiap.ms.login.adapters.out.repository;

import com.fiap.ms.login.adapters.out.repository.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {

    Optional<LoginEntity> findLoginByUsuario(String usuario);
    Optional<LoginEntity> findByUsuarioOrDocumento(String usuario, String documento);
}
