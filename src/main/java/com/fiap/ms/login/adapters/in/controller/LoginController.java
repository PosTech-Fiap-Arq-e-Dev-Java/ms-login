package com.fiap.ms.login.adapters.in.controller;

import com.fiap.ms.login.LoginApi;
import com.fiap.ms.login.adapters.in.controller.mapper.AuthRegisterDtoMapper;
import com.fiap.ms.login.application.ports.in.AuthRegisterInputPort;
import com.fiap.ms.login.application.ports.in.DeleteLoginInputPort;
import com.fiap.ms.login.gen.model.AuthLoginDto;
import com.fiap.ms.login.gen.model.AuthRegisterDto;
import com.fiap.ms.login.gen.model.UpdatePasswordDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1")
public class LoginController implements LoginApi {

    private final AuthRegisterInputPort authRegisterInputPort;
    private final DeleteLoginInputPort deleteLoginInputPort;
    private final AuthRegisterDtoMapper authRegisterDtoMapper;

    public LoginController(AuthRegisterInputPort authRegisterInputPort,
                           DeleteLoginInputPort deleteLoginInputPort,
                           AuthRegisterDtoMapper authRegisterDtoMapper) {
        this.authRegisterInputPort = authRegisterInputPort;
        this.deleteLoginInputPort = deleteLoginInputPort;
        this.authRegisterDtoMapper = authRegisterDtoMapper;
    }

    @Override
    public ResponseEntity<Void> _authLogin(AuthLoginDto authLoginRequestDto) {
        return ResponseEntity.ok().build();

    }

    @Override
    public ResponseEntity<Void> _authRegister(AuthRegisterDto authRegisterRequestDto) {
        var login = authRegisterDtoMapper.toLogin(authRegisterRequestDto);
        authRegisterInputPort.insert(login);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> _deleteLogin(String cpf) {
        deleteLoginInputPort.delete(cpf);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> _updatePassword(String idLogin, UpdatePasswordDto updatePasswordRequestDto) {
        return ResponseEntity.ok().build();
    }
}
