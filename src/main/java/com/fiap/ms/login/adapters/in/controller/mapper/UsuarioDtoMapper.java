package com.fiap.ms.login.adapters.in.controller.mapper;

import com.fiap.ms.login.application.core.domain.UsuarioDomain;
import com.fiap.ms.login.gen.model.UsuarioDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UsuarioDtoMapper {

    UsuarioDtoMapper INSTANCE = Mappers.getMapper(UsuarioDtoMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tipoUsuario", ignore = true)
    @Mapping(target = "statusUsuario", ignore = true)
    @Mapping(target = "documento", source = "documento")
    UsuarioDomain toLogin(UsuarioDto usuarioDto);
}
