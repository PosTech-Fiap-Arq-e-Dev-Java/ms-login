package com.fiap.ms.login.adapters.out;

import com.fiap.ms.login.adapters.out.repository.LoginRepository;
import com.fiap.ms.login.application.ports.out.DeleteLoginOutputPort;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteLoginAdapter implements DeleteLoginOutputPort {

    @Autowired
    private LoginRepository loginRepository;

    @Transactional
    @Override
    public void delete(Integer id) {
        loginRepository.deleteById(id);
    }
}
