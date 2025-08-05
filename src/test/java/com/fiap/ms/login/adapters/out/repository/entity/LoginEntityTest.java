package com.fiap.ms.login.adapters.out.repository.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginEntityTest {

    @Test
    void testAllArgsConstructor() {
        TipoUsuarioEntity tipoUsuario = new TipoUsuarioEntity();
        StatusUsuarioEntity statusUsuario = new StatusUsuarioEntity();

        LoginEntity login = new LoginEntity(
                1,
                "usuario123",
                "senhaSegura",
                "12345678900",
                tipoUsuario,
                statusUsuario
        );

        assertEquals(1, login.getId());
        assertEquals("usuario123", login.getUsuario());
        assertEquals("senhaSegura", login.getSenha());
        assertEquals("12345678900", login.getDocumento());
        assertEquals(tipoUsuario, login.getTipoUsuario());
        assertEquals(statusUsuario, login.getStatusUsuario());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        LoginEntity login = new LoginEntity();

        login.setId(2);
        login.setUsuario("teste");
        login.setSenha("senha123");
        login.setDocumento("98765432100");

        assertEquals(2, login.getId());
        assertEquals("teste", login.getUsuario());
        assertEquals("senha123", login.getSenha());
        assertEquals("98765432100", login.getDocumento());
    }

    @Test
    void testEqualsAndHashCode() {
        LoginEntity login1 = new LoginEntity(1, "usuario", "senha", "doc", null, null);
        LoginEntity login2 = new LoginEntity(1, "usuario", "senha", "doc", null, null);

        assertEquals(login1, login2);
        assertEquals(login1.hashCode(), login2.hashCode());
    }

    @Test
    void testToString() {
        LoginEntity login = new LoginEntity(1, "usuario", "senha", "doc", null, null);
        String result = login.toString();

        assertTrue(result.contains("usuario"));
        assertTrue(result.contains("senha"));
        assertTrue(result.contains("doc"));
    }
}

