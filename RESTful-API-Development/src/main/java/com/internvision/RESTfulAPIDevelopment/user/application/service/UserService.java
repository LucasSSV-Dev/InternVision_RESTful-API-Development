package com.internvision.RESTfulAPIDevelopment.user.application.service;

import com.internvision.RESTfulAPIDevelopment.user.application.api.dto.CreateUserDTO;
import com.internvision.RESTfulAPIDevelopment.user.domain.User;

public interface UserService {

    User createUser(CreateUserDTO dto);
}
