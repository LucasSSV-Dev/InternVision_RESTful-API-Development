package com.internvision.RESTfulAPIDevelopment.user.infra.mappers;

import com.internvision.RESTfulAPIDevelopment.user.application.api.dto.CreateOrUpdateUserDTO;
import com.internvision.RESTfulAPIDevelopment.user.domain.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "active", ignore = true)
    User toUser(CreateOrUpdateUserDTO dto);

    @AfterMapping
    default void setActiveTrue(@MappingTarget User entity) {
        entity.setActive(true);
    }
}
