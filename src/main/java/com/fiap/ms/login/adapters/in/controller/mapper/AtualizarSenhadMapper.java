package com.fiap.ms.login.adapters.in.controller.mapper;

import com.fiap.ms.login.application.core.domain.AtualizarSenhaDomain;
import com.fiap.ms.login.gen.model.AtualizarSenhaDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AtualizarSenhadMapper {

    AtualizarSenhadMapper INSTANCE = Mappers.getMapper(AtualizarSenhadMapper.class);

    AtualizarSenhaDomain toAtualizarSenhaDomain(AtualizarSenhaDto atualizarSenhaDto);
}
