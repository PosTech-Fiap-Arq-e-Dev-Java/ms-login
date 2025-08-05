package com.fiap.ms.login.adapters.in.controller.mapper;

import com.fiap.ms.login.application.core.domain.AtualizarSenhaDomain;
import com.fiap.ms.login.gen.model.AtualizarSenhaDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AtualizarSenhaDtoMapper {

    AtualizarSenhaDtoMapper INSTANCE = Mappers.getMapper(AtualizarSenhaDtoMapper.class);

    AtualizarSenhaDomain toAtualizarSenhaDomain(AtualizarSenhaDto atualizarSenhaDto);
}
