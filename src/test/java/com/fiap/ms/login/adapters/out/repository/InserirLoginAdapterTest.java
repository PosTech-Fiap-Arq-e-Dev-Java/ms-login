package com.fiap.ms.login.adapters.out.repository;

import com.fiap.ms.login.adapters.out.InserirLoginAdapter;
import com.fiap.ms.login.adapters.out.repository.entity.LoginEntity;
import com.fiap.ms.login.adapters.out.repository.mapper.LoginEntityMapper;
import com.fiap.ms.login.application.core.domain.UsuarioDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.fiap.ms.login.common.utils.MocksUsuario.getUsuarioDomain;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class InserirLoginAdapterTest {

    @Mock
    private LoginRepository loginRepository;

    @Mock
    private LoginEntityMapper loginEntityMapper;

    @InjectMocks
    private InserirLoginAdapter inserirLoginAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveInserirLoginComSucesso() {
        UsuarioDomain usuarioDomain = getUsuarioDomain();
        LoginEntity loginEntity = LoginEntityMapper.INSTANCE.toLoginEntity(usuarioDomain);

        when(loginEntityMapper.toLoginEntity(usuarioDomain)).thenReturn(loginEntity);

        inserirLoginAdapter.inserir(usuarioDomain);

        verify(loginEntityMapper, times(1)).toLoginEntity(usuarioDomain);
        verify(loginRepository, times(1)).save(loginEntity);
    }

    @Test
    void devePropagarExcecaoDoRepository() {
        UsuarioDomain usuarioDomain = getUsuarioDomain();
        LoginEntity loginEntity = LoginEntityMapper.INSTANCE.toLoginEntity(usuarioDomain);

        when(loginEntityMapper.toLoginEntity(usuarioDomain)).thenReturn(loginEntity);
        doThrow(new RuntimeException("Erro ao salvar")).when(loginRepository).save(loginEntity);

        assertThrows(RuntimeException.class, () -> {
            inserirLoginAdapter.inserir(usuarioDomain);
        });

        verify(loginEntityMapper).toLoginEntity(usuarioDomain);
        verify(loginRepository).save(loginEntity);
    }
}
