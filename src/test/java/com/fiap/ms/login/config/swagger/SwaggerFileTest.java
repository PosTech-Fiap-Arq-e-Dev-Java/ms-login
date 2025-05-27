package com.fiap.ms.login.config.swagger;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SwaggerFileTest {

    @Test
    void swaggerYamlDeveExistir() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("swagger-ui/swagger.yaml");
        assertNotNull(inputStream, "O arquivo swagger.yaml não foi encontrado no caminho esperado.");
    }

    @Test
    void swaggerYamlNaoExiste() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("swagger-ui/inexistente.yaml");
        assertNull(inputStream, "O arquivo não deveria existir, mas foi encontrado.");
    }

    @Test
    void deveLancarExcecaoQuandoSwaggerYamlNaoExiste() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("swagger-ui/inexistente.yaml");
            if (inputStream == null) {
                throw new RuntimeException("Arquivo swagger.yaml não encontrado.");
            }
        });

        assertEquals("Arquivo swagger.yaml não encontrado.", exception.getMessage());
    }

}