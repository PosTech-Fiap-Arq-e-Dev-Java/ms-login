package com.fiap.ms.login.adapters.out;

import com.fiap.ms.login.adapters.out.repository.LoginRepository;
import com.fiap.ms.login.application.ports.out.DeletarLoginOutputPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeletarLoginAdapter implements DeletarLoginOutputPort {

    private final LoginRepository loginRepository;

    @Override
    @Transactional
    public void deletar(Integer id) {
        loginRepository.deleteById(id);
    }
}
