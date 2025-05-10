package com.fiap.ms.login.adapters.in;

import com.fiap.ms.login.LoginApi;
import com.fiap.ms.login.gen.model.AuthLoginRequestDto;
import com.fiap.ms.login.gen.model.AuthRegisterRequestDto;
import com.fiap.ms.login.gen.model.UpdatePasswordRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1")
public class LoginController implements LoginApi {

    @Override
    public ResponseEntity<Void> _authLogin(AuthLoginRequestDto authLoginRequestDto) {
        return ResponseEntity.ok().build();

    }

    @Override
    public ResponseEntity<Void> _authRegister(AuthRegisterRequestDto authRegisterRequestDto) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> _deleteLogin(String idLogin) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> _updatePassword(String idLogin, UpdatePasswordRequestDto updatePasswordRequestDto) {
        return ResponseEntity.ok().build();
    }
}
