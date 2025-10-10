package com.internvision.RESTfulAPIDevelopment.user.application.service;

import com.internvision.RESTfulAPIDevelopment.user.application.api.dto.CreateUserDTO;
import com.internvision.RESTfulAPIDevelopment.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User createUser(CreateUserDTO dto);

    List<User> getAllUsers();
}
