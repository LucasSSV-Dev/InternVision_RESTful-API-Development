package com.internvision.RESTfulAPIDevelopment.user.application.service;

import com.internvision.RESTfulAPIDevelopment.user.infra.dto.ChangePasswordRequestDTO;
import com.internvision.RESTfulAPIDevelopment.user.infra.dto.CreateOrUpdateUserDTO;
import com.internvision.RESTfulAPIDevelopment.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User createUser(CreateOrUpdateUserDTO dto);

    List<User> getAllUsers();

    User getUserById(String id);

    void updateUser(String id, CreateOrUpdateUserDTO userUpdateRequest);

    void deleteUser(String id);

    void changePassword(String id, ChangePasswordRequestDTO passwordRequestDTO);
}
