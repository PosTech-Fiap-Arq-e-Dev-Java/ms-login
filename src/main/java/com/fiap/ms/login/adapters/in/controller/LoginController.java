package com.fiap.ms.login.adapters.in.controller;

import com.fiap.ms.login.LoginApi;
import com.fiap.ms.login.adapters.in.controller.mapper.AtualizarSenhadMapper;
import com.fiap.ms.login.adapters.in.controller.mapper.AuthRegisterDtoMapper;
import com.fiap.ms.login.application.ports.in.AtualizarSenhaInputPort;
import com.fiap.ms.login.application.ports.in.AutenticarLoginInputPort;
import com.fiap.ms.login.application.ports.in.BuscarUsuarioInputPort;
import com.fiap.ms.login.application.ports.in.DeletarLoginInputPort;
import com.fiap.ms.login.application.ports.in.InserirLoginInputPort;
import com.fiap.ms.login.gen.model.AtualizarSenhaDto;
import com.fiap.ms.login.gen.model.AutenticacaoUsuarioDto;
import com.fiap.ms.login.gen.model.AutenticacaoUsuarioResponseDto;
import com.fiap.ms.login.gen.model.StatusUsuarioDto;
import com.fiap.ms.login.gen.model.UsuarioDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1")
public class LoginController implements LoginApi {

    private final InserirLoginInputPort inserirLoginInputPort;
    private final DeletarLoginInputPort deletarLoginInputPort;
    private final BuscarUsuarioInputPort buscarUsuarioInputPort;
    private final AtualizarSenhaInputPort atualizarSenhaInputPort;
    private final AutenticarLoginInputPort autenticarLoginInputPort;

    public LoginController(InserirLoginInputPort inserirLoginInputPort,
                           DeletarLoginInputPort deletarLoginInputPort,
                           BuscarUsuarioInputPort buscarUsuarioInputPort,
                           AtualizarSenhaInputPort atualizarSenhaInputPort,
                           AutenticarLoginInputPort autenticarLoginInputPort) {
        this.inserirLoginInputPort = inserirLoginInputPort;
        this.deletarLoginInputPort = deletarLoginInputPort;
        this.buscarUsuarioInputPort = buscarUsuarioInputPort;
        this.atualizarSenhaInputPort = atualizarSenhaInputPort;
        this.autenticarLoginInputPort = autenticarLoginInputPort;
    }

    @Override
    public ResponseEntity<Void> _atualizarSenha(String usuario, AtualizarSenhaDto atualizarSenhaDto) {
        var atualizarSenhaDomain = AtualizarSenhadMapper.INSTANCE.toAtualizarSenhaDomain(atualizarSenhaDto);
        atualizarSenhaInputPort.atualizar(usuario, atualizarSenhaDomain);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<AutenticacaoUsuarioResponseDto> _autenticarUsuario(AutenticacaoUsuarioDto autenticacaoUsuarioDto) {
        var authLogin = autenticarLoginInputPort.buscar(autenticacaoUsuarioDto.getUsuario(), autenticacaoUsuarioDto.getSenha());
        AutenticacaoUsuarioResponseDto autenticacaoUsuarioResponseDto = new AutenticacaoUsuarioResponseDto();
        autenticacaoUsuarioResponseDto.setUsuario(authLogin.getUsuario());
        autenticacaoUsuarioResponseDto.setTipoUsuario(authLogin.getTipoUsuarioEnum().getDescricao());
        return ResponseEntity.ok(autenticacaoUsuarioResponseDto);
    }

    @Override
    public ResponseEntity<StatusUsuarioDto> _buscarStatus(String usuario) {
        var status = buscarUsuarioInputPort.buscar(usuario);

        StatusUsuarioDto statusDto = new StatusUsuarioDto();
        statusDto.setStatus(status.getStatusUsuario().getStatus());
        statusDto.setUsuario(status.getUsuario());

        return ResponseEntity.ok(statusDto);
    }

    @Override
    public ResponseEntity<Void> _criarLogin(UsuarioDto usuarioDto) {
        var login = AuthRegisterDtoMapper.INSTANCE.toLogin(usuarioDto);
        inserirLoginInputPort.inserir(login);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> _deletarLogin(String usuario) {
        deletarLoginInputPort.deletar(usuario);
        return ResponseEntity.noContent().build();
    }
}
