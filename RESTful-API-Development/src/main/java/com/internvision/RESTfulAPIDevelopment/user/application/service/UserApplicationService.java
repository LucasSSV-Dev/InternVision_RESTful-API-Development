package com.internvision.RESTfulAPIDevelopment.user.application.service;

import com.internvision.RESTfulAPIDevelopment.tools.mapper.UserMapper;
import com.internvision.RESTfulAPIDevelopment.user.application.api.dto.CreateUserDTO;
import com.internvision.RESTfulAPIDevelopment.user.application.repository.UserRepository;
import com.internvision.RESTfulAPIDevelopment.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserApplicationService implements UserService {

    private final UserRepository userRepository;
    private final UserMapper UserMapper;

    @Override
    public User createUser(CreateUserDTO dto){
        User user = UserMapper.toUser(dto);
        userRepository.save(user);
        return user;
    }

}
