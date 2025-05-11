package com.fiap.ms.login.adapters.in.controller.mapper;

import com.fiap.ms.login.application.core.domain.LoginDomain;
import com.fiap.ms.login.gen.model.AuthRegisterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AuthRegisterDtoMapper {

    AuthRegisterDtoMapper INSTANCE = Mappers.getMapper(AuthRegisterDtoMapper.class);

    @Mapping(target = "id", ignore = true)
    LoginDomain toLogin(AuthRegisterDto authRegisterDto);
}
