package com.fiap.ms.login.adapters.out;

import com.fiap.ms.login.adapters.out.repository.LoginRepository;
import com.fiap.ms.login.application.ports.out.DeletarLoginOutputPort;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletarLoginAdapter implements DeletarLoginOutputPort {

    @Autowired
    private LoginRepository loginRepository;

    @Transactional
    @Override
    public void deletar(Integer id) {
        loginRepository.deleteById(id);
    }
}
