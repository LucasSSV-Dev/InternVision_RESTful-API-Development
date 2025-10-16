package com.internvision.RESTfulAPIDevelopment.user.infra.mappers;

import com.internvision.RESTfulAPIDevelopment.user.application.api.dto.CreateUserDTO;
import com.internvision.RESTfulAPIDevelopment.user.domain.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(CreateUserDTO dto);


    @AfterMapping
    default void setDefaultActive(@MappingTarget User entity) {
        entity.setActive(true);
    }
}
