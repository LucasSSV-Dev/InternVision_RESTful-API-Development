package com.internvision.RESTfulAPIDevelopment.tools.mapper;

import com.internvision.RESTfulAPIDevelopment.user.application.api.dto.CreateUserDTO;
import com.internvision.RESTfulAPIDevelopment.user.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(CreateUserDTO dto);

}
