package com.fiap.ms.login.adapters.out.repository.mapper;

import com.fiap.ms.login.adapters.in.controller.mapper.LoginDtoMapper;
import com.fiap.ms.login.adapters.out.repository.entity.LoginEntity;
import com.fiap.ms.login.application.core.domain.Login;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface LoginEntityMapper {

    LoginDtoMapper INSTANCE = Mappers.getMapper(LoginDtoMapper.class);

    LoginEntity toLoginEntity(Login login);

    Login toLogin(LoginEntity loginEntity);
}
