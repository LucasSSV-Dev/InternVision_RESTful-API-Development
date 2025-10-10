package com.internvision.RESTfulAPIDevelopment.user.infra;

import com.internvision.RESTfulAPIDevelopment.user.application.api.dto.CreateUserDTO;
import com.internvision.RESTfulAPIDevelopment.user.application.repository.UserRepository;
import com.internvision.RESTfulAPIDevelopment.user.application.service.UserService;
import com.internvision.RESTfulAPIDevelopment.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserApplicationService implements UserService {

    private final UserRepository userRepository;
    private final UserMapper UserMapper;

    @Override
    public User createUser(CreateUserDTO dto){
        log.info("[starts] UserApplicationService -> createUser()");
        User user = UserMapper.toUser(dto);
        userRepository.save(user);
        log.info("[ends] UserApplicationService -> createUser()");
        return user;
    }

    @Override
    public List<User> getAllUsers(){
        log.info("[starts] UserApplicationService -> getAllUsers()");
        List<User> userList = userRepository.findAllByActiveTrue();
        log.info("[ends] UserApplicationService -> getAllUsers()");
        return userList;
    }

}
