package com.fiap.ms.login.adapters.in.controller;

import com.fiap.ms.login.LoginApi;
import com.fiap.ms.login.adapters.in.controller.mapper.AuthRegisterDtoMapper;
import com.fiap.ms.login.adapters.in.controller.mapper.UpdatePasswordMapper;
import com.fiap.ms.login.application.ports.in.InsertLoginInputPort;
import com.fiap.ms.login.application.ports.in.DeleteLoginInputPort;
import com.fiap.ms.login.application.ports.in.GetLoginInputPort;
import com.fiap.ms.login.application.ports.in.PatchLoginInputPort;
import com.fiap.ms.login.gen.model.AuthLoginDto;
import com.fiap.ms.login.gen.model.AuthRegisterDto;
import com.fiap.ms.login.gen.model.AuthStatusDto;
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

    private final InsertLoginInputPort insertLoginInputPort;
    private final DeleteLoginInputPort deleteLoginInputPort;
    private final GetLoginInputPort getLoginInputPort;
    private final PatchLoginInputPort patchLoginInputPort;

    public LoginController(InsertLoginInputPort insertLoginInputPort,
                           DeleteLoginInputPort deleteLoginInputPort,
                           GetLoginInputPort getLoginInputPort,
                           PatchLoginInputPort patchLoginInputPort) {
        this.insertLoginInputPort = insertLoginInputPort;
        this.deleteLoginInputPort = deleteLoginInputPort;
        this.getLoginInputPort = getLoginInputPort;
        this.patchLoginInputPort = patchLoginInputPort;
    }

    @Override
    public ResponseEntity<Void> _authLogin(AuthLoginDto authLoginRequestDto) {
        return ResponseEntity.ok().build();

    }

    @Override
    public ResponseEntity<Void> _authRegister(AuthRegisterDto authRegisterRequestDto) {
        var login = AuthRegisterDtoMapper.INSTANCE.toLogin(authRegisterRequestDto);
        insertLoginInputPort.insert(login);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<AuthStatusDto> _authStatus(String usuario) {
        var status = getLoginInputPort.find(usuario);

        AuthStatusDto statusDto = new AuthStatusDto();
        statusDto.setStatus(status.getStatusUsuario().getStatus());
        statusDto.setUsuario(status.getUsuario());

        return ResponseEntity.ok(statusDto);
    }

    @Override
    public ResponseEntity<Void> _deleteLogin(String usuario) {
        deleteLoginInputPort.delete(usuario);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> _updatePassword(String usuario, UpdatePasswordDto updatePasswordDto) {
        var domain = UpdatePasswordMapper.INSTANCE.toUpdatePasswordDomain(updatePasswordDto);
        patchLoginInputPort.update(usuario, domain);
        return ResponseEntity.noContent().build();
    }
}
