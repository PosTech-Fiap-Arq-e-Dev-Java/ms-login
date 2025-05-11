package com.fiap.ms.login.adapters.out.repository.mapper;

import com.fiap.ms.login.adapters.in.controller.mapper.AuthRegisterDtoMapper;
import com.fiap.ms.login.adapters.out.repository.entity.LoginEntity;
import com.fiap.ms.login.application.core.domain.LoginDomain;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface LoginEntityMapper {

    AuthRegisterDtoMapper INSTANCE = Mappers.getMapper(AuthRegisterDtoMapper.class);

    LoginEntity toLoginEntity(LoginDomain loginDomain);

    LoginDomain toLogin(LoginEntity loginEntity);
}
