package com.fiap.ms.login.adapters.in.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface LoginDtoMapper {

    LoginDtoMapper INSTANCE = Mappers.getMapper(LoginDtoMapper.class);

}
