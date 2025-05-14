package com.fiap.ms.login.adapters.in.controller.mapper;

import com.fiap.ms.login.application.core.domain.UpdatePasswordDomain;
import com.fiap.ms.login.gen.model.UpdatePasswordDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UpdatePasswordMapper {

    UpdatePasswordMapper INSTANCE = Mappers.getMapper(UpdatePasswordMapper.class);

    UpdatePasswordDomain toUpdatePasswordDomain(UpdatePasswordDto updatePasswordDto);
}
