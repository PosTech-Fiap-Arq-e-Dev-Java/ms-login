package com.fiap.ms.login.adapters.in.controller;

import com.fiap.ms.login.application.core.domain.AtualizarSenhaDomain;
import com.fiap.ms.login.application.core.domain.AutenticacaoLoginDomain;
import com.fiap.ms.login.application.core.domain.enums.TipoUsuarioEnum;
import com.fiap.ms.login.application.ports.in.*;
import com.fiap.ms.login.gen.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class LoginControllerTest {


    @Mock
    private DeletarLoginInputPort deletarLoginInputPort;


    @Mock
    private AtualizarSenhaInputPort atualizarSenhaInputPort;

    @Mock
    private AutenticarLoginInputPort autenticarLoginInputPort;

    @InjectMocks
    private LoginController loginController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void atualizarSenha_deveConverterDtoEChamarPort() {
        String usuario = "usuario123";
        AtualizarSenhaDto dto = new AtualizarSenhaDto();
        dto.setSenhaAntiga("senhaAntiga");
        dto.setSenhaNova("senhaNova");

        ResponseEntity<Void> response = loginController._atualizarSenha(usuario, dto);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

        ArgumentCaptor<AtualizarSenhaDomain> captor = ArgumentCaptor.forClass(AtualizarSenhaDomain.class);
        verify(atualizarSenhaInputPort).atualizar(eq(usuario), captor.capture());

        AtualizarSenhaDomain domainArg = captor.getValue();
        assertThat(domainArg.getSenhaAntiga()).isEqualTo(dto.getSenhaAntiga());
        assertThat(domainArg.getSenhaNova()).isEqualTo(dto.getSenhaNova());
    }

    @Test
    void autenticarUsuario_deveRetornarResponseCorreto() {
        AutenticacaoUsuarioDto dto = new AutenticacaoUsuarioDto();
        dto.setUsuario("usuario123");
        dto.setSenha("senha123");

        AutenticacaoLoginDomain domain = new AutenticacaoLoginDomain("usuario123", TipoUsuarioEnum.CLIENTE);

        when(autenticarLoginInputPort.buscar(dto.getUsuario(), dto.getSenha())).thenReturn(domain);

        ResponseEntity<AutenticacaoUsuarioResponseDto> response = loginController._autenticarUsuario(dto);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getUsuario()).isEqualTo(domain.getUsuario());
        assertThat(response.getBody().getTipoUsuario()).isEqualTo(domain.getTipoUsuarioEnum().getDescricao());

        verify(autenticarLoginInputPort).buscar(dto.getUsuario(), dto.getSenha());
    }


    @Test
    void deletarLogin_deveChamarPortERetornarNoContent() {
        String usuario = "usuario123";

        ResponseEntity<Void> response = loginController._deletarLogin(usuario);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        verify(deletarLoginInputPort).deletar(usuario);
    }
}





