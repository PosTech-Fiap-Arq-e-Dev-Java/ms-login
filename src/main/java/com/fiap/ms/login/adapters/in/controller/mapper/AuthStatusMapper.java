package com.fiap.ms.login.adapters.in.controller.mapper;

import com.fiap.ms.login.application.core.domain.LoginDomain;
import com.fiap.ms.login.gen.model.AuthStatusDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AuthStatusMapper {

    AuthStatusMapper INSTANCE = Mappers.getMapper(AuthStatusMapper.class);

    @Mapping(source = "usuario", target = "usuario")
    @Mapping(source = "statusUsuario", target = "status")
    AuthStatusDto toAuthStatusDto(LoginDomain loginDomain);
}