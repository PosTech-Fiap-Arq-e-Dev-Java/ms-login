package com.fiap.ms.login.adapters.out.repository;

import com.fiap.ms.login.adapters.out.repository.entity.LoginEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {

    Optional<LoginEntity> findLoginByUsuario(String usuario);

    Optional<LoginEntity> findByUsuarioOrDocumento(String usuario, String documento);

    Optional<LoginEntity> findByUsuarioAndSenha(String usuario, String senha);
    
    @Query("UPDATE tb_login l SET l.senha = :senha WHERE l.usuario = :usuario")
    @Modifying
    @Transactional
    void atualizarSenha(@Param("usuario") String usuario, @Param("senha") String senha);

}
