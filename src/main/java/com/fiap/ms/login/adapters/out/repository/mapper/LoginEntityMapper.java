package com.fiap.ms.login.adapters.out.repository.mapper;

import com.fiap.ms.login.adapters.in.controller.mapper.AuthRegisterDtoMapper;
import com.fiap.ms.login.adapters.out.repository.entity.LoginEntity;
import com.fiap.ms.login.adapters.out.repository.entity.StatusUsuarioEntity;
import com.fiap.ms.login.adapters.out.repository.entity.TipoUsuarioEntity;
import com.fiap.ms.login.application.core.domain.LoginDomain;
import com.fiap.ms.login.application.core.domain.enums.StatusUsuarioEnum;
import com.fiap.ms.login.application.core.domain.enums.TipoUsuarioEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface LoginEntityMapper {

    LoginEntityMapper INSTANCE = Mappers.getMapper(LoginEntityMapper.class);

    @Mapping(source = "tipoUsuario", target = "tipoUsuario")
    LoginEntity toLoginEntity(LoginDomain loginDomain);

    @Mapping(source = "tipoUsuario", target = "tipoUsuario")
    LoginDomain toLogin(LoginEntity loginEntity);

    default TipoUsuarioEntity map(TipoUsuarioEnum tipoUsuarioEnum) {
        if (tipoUsuarioEnum == null) return null;

        TipoUsuarioEntity entity = new TipoUsuarioEntity();
        entity.setId((long) tipoUsuarioEnum.getId());
        entity.setDescricao(tipoUsuarioEnum.getDescricao());
        return entity;
    }

    default TipoUsuarioEnum map(TipoUsuarioEntity tipoUsuarioEntity) {
        if (tipoUsuarioEntity == null) {
            return null;
        }

        return Arrays.stream(TipoUsuarioEnum.values())
                .filter(e -> e.getId() == tipoUsuarioEntity.getId())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("TipoUsuarioEntity inválido: " + tipoUsuarioEntity.getId()));
    }

    default StatusUsuarioEntity map(StatusUsuarioEnum statusUsuarioEnum) {
        if (statusUsuarioEnum == null) return null;

        StatusUsuarioEntity entity = new StatusUsuarioEntity();
        entity.setId((long) statusUsuarioEnum.getId());
        entity.setStatus(statusUsuarioEnum.getStatus());
        return entity;
    }

    default StatusUsuarioEnum map(StatusUsuarioEntity statusUsuarioEntity) {
        if (statusUsuarioEntity == null) {
            return null;
        }

        return Arrays.stream(StatusUsuarioEnum.values())
                .filter(e -> e.getId() == statusUsuarioEntity.getId())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("TipoUsuarioEntity inválido: " + statusUsuarioEntity.getId()));
    }
}
