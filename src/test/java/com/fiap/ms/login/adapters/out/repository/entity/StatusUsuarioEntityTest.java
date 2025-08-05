package com.fiap.ms.login.adapters.out.repository.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusUsuarioEntityTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        Long id = 1L;
        String status = "ATIVO";

        StatusUsuarioEntity entity = new StatusUsuarioEntity(id, status);

        assertEquals(id, entity.getId());
        assertEquals(status, entity.getStatus());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        StatusUsuarioEntity entity = new StatusUsuarioEntity();
        entity.setId(2L);
        entity.setStatus("INATIVO");

        assertEquals(2L, entity.getId());
        assertEquals("INATIVO", entity.getStatus());
    }

    @Test
    void testEqualsAndHashCode() {
        StatusUsuarioEntity entity1 = new StatusUsuarioEntity(3L, "ATIVO");
        StatusUsuarioEntity entity2 = new StatusUsuarioEntity(3L, "ATIVO");

        assertEquals(entity1, entity2);
        assertEquals(entity1.hashCode(), entity2.hashCode());
    }

    @Test
    void testToString() {
        StatusUsuarioEntity entity = new StatusUsuarioEntity(4L, "BLOQUEADO");
        String toString = entity.toString();

        assertTrue(toString.contains("id=4"));
        assertTrue(toString.contains("status=BLOQUEADO"));
    }
}

