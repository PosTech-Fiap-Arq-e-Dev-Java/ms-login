package com.fiap.ms.login.adapters.out;

import com.fiap.ms.login.adapters.out.repository.LoginRepository;
import com.fiap.ms.login.adapters.out.repository.mapper.LoginEntityMapper;
import com.fiap.ms.login.application.core.domain.LoginDomain;
import com.fiap.ms.login.application.ports.out.InsertLoginOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertLoginAdapter implements InsertLoginOutputPort {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private LoginEntityMapper loginEntityMapper;

    @Override
    public void insert(LoginDomain login) {
        var loginEntity = loginEntityMapper.toLoginEntity(login);
        loginRepository.save(loginEntity);
    }
}
