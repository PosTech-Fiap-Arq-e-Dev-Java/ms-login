package com.fiap.ms.login.adapters.out.repository;

import com.fiap.ms.login.adapters.out.DeletarLoginAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DeletarLoginAdapterTest {

    @Mock
    private LoginRepository loginRepository;

    @InjectMocks
    private DeletarLoginAdapter deletarLoginAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveDeletarComIdValido() {
        Integer id = 1;

        deletarLoginAdapter.deletar(id);

        verify(loginRepository, times(1)).deleteById(id);
    }

    @Test
    void devePropagarExcecaoSeRepositoryFalhar() {
        Integer id = 99;

        doThrow(new RuntimeException("Erro ao deletar")).when(loginRepository).deleteById(id);

        assertThrows(RuntimeException.class, () -> {
            deletarLoginAdapter.deletar(id);
        });

        verify(loginRepository).deleteById(id);
    }
}
