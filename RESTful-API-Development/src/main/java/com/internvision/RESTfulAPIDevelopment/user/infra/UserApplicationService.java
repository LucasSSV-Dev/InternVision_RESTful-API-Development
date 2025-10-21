package com.internvision.RESTfulAPIDevelopment.user.infra;

import com.internvision.RESTfulAPIDevelopment.GlobalHandler.exception.UserNotFoundException;
import com.internvision.RESTfulAPIDevelopment.user.application.api.dto.CreateOrUpdateUserDTO;
import com.internvision.RESTfulAPIDevelopment.user.application.repository.UserRepository;
import com.internvision.RESTfulAPIDevelopment.user.application.service.UserService;
import com.internvision.RESTfulAPIDevelopment.user.domain.User;
import com.internvision.RESTfulAPIDevelopment.user.infra.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserApplicationService implements UserService {

    private final UserRepository userRepository;
    private final UserMapper UserMapper;

    @Override
    public User createUser(CreateOrUpdateUserDTO dto){
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

    @Override
    public User getUserById(String id){
        log.info("[starts] UserApplicationService -> getUserById()");
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        log.info("[ends] UserApplicationService -> getUserById()");
        return user.get();
    }

    @Override
    public void updateUser(String id, CreateOrUpdateUserDTO userUpdateRequest){
        log.info("[starts] UserApplicationService -> updateUser()");
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }

        User user = optionalUser.get();
        User updatedUser = user.updateUser(id, userUpdateRequest);

        userRepository.save(updatedUser);
        log.info("[ends] UserApplicationService -> updateUser()");
    }

    @Override
    public void deleteUser(String id){
        log.info("[starts] UserApplicationService -> deleteUser()");
        userRepository.deleteById(id);
        log.info("[ends] UserApplicationService -> deleteUser()");
    }
}
