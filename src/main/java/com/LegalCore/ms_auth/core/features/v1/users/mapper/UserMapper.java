package com.LegalCore.ms_auth.core.features.v1.users.mapper;

import com.LegalCore.ms_auth.core.features.v1.users.dto.UserRequestDTO;
import com.LegalCore.ms_auth.core.features.v1.users.dto.UserResponseDTO;
import com.LegalCore.ms_auth.core.features.v1.users.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Builder;

@Mapper(componentModel = "spring")
public interface UserMapper {


    // DTO -> Entity usando builder
    UserEntity toEntity(UserRequestDTO dto);

    // Entity -> ResponseDTO
    UserResponseDTO toResponse(UserEntity entity);

    // Para actualizar una entidad existente con un DTO
    void updateEntityFromDTO(UserRequestDTO dto, @MappingTarget UserEntity entity);
}
