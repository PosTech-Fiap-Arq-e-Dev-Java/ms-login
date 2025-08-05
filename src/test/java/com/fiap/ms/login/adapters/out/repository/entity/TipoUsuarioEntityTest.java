package com.fiap.ms.login.adapters.out.repository.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TipoUsuarioEntityTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        Long id = 1L;
        String descricao = "Parceiro";

        TipoUsuarioEntity entity = new TipoUsuarioEntity(id, descricao);

        assertEquals(id, entity.getId());
        assertEquals(descricao, entity.getDescricao());
    }

    @Test
    void testSettersAndNoArgsConstructor() {
        TipoUsuarioEntity entity = new TipoUsuarioEntity();

        Long id = 2L;
        String descricao = "Comum";

        entity.setId(id);
        entity.setDescricao(descricao);

        assertEquals(id, entity.getId());
        assertEquals(descricao, entity.getDescricao());
    }

    @Test
    void testEqualsAndHashCode() {
        TipoUsuarioEntity entity1 = new TipoUsuarioEntity(1L, "Comum");
        TipoUsuarioEntity entity2 = new TipoUsuarioEntity(1L, "Comum");

        assertEquals(entity1, entity2);
        assertEquals(entity1.hashCode(), entity2.hashCode());
    }

    @Test
    void testToString() {
        TipoUsuarioEntity entity = new TipoUsuarioEntity(1L, "Parceiro");
        String expected = "TipoUsuarioEntity(id=1, descricao=Parceiro)";

        assertEquals(expected, entity.toString());
    }
}
