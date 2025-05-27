package com.fiap.ms.login.adapters.out.repository;

import com.fiap.ms.login.adapters.out.AtualizarSenhaAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.fiap.ms.login.common.utils.MocksUsuario.getUsuarioDomain;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AtualizarSenhaAdapterTest {

    @Mock
    private LoginRepository loginRepository;

    @InjectMocks
    private AtualizarSenhaAdapter atualizarSenhaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveAtualizarComSucesso() {
       var loginDomain = getUsuarioDomain();

        doNothing().when(loginRepository).atualizarSenha(anyString(), anyString());

        atualizarSenhaAdapter.atualizar(loginDomain);

        verify(loginRepository, times(1)).atualizarSenha("usuario", "senha");
    }

    @Test
    void deveLancarExcecaoQuandoUsuarioDomainForNull() {
        assertThrows(NullPointerException.class, () -> {
            atualizarSenhaAdapter.atualizar(null);
        });

        verify(loginRepository, never()).atualizarSenha(anyString(), anyString());
    }

}
