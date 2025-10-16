package com.internvision.RESTfulAPIDevelopment.user.infra.mappers;

import com.internvision.RESTfulAPIDevelopment.user.application.api.dto.CreateOrUpdateUserDTO;
import com.internvision.RESTfulAPIDevelopment.user.domain.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(CreateOrUpdateUserDTO dto);


    @AfterMapping
    default void setDefaultActive(@MappingTarget User entity) {
        entity.setActive(true);
    }

    User updateUser(User user, CreateOrUpdateUserDTO userUpdateRequest);
}
