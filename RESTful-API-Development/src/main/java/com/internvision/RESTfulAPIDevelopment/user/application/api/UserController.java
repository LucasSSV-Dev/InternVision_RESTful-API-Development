package com.internvision.RESTfulAPIDevelopment.user.application.api;

import com.internvision.RESTfulAPIDevelopment.user.application.api.dto.CreateUserDTO;
import com.internvision.RESTfulAPIDevelopment.user.application.service.UserService;
import com.internvision.RESTfulAPIDevelopment.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<Object> postCreateUser(CreateUserDTO dto) {
        log.info("[starts] UserController -> createUser()");
        User user = userService.createUser(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        log.info("[ends] UserController -> createUser()");
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<Object> getAllUsers() {
        log.info("[starts] UserController -> getAllUsers()");
        List<User> userList = userService.getAllUsers();
        log.info("[ends] UserController -> getAllUsers()");
        return ResponseEntity.ok().body(userList);
    }

    @Override
    public ResponseEntity<Object> getUserById(String id){
        log.info("[starts] UserController -> getUserById()");
        User user = userService.getUserById(id);
        log.info("[ends] UserController -> getUserById()");
        return ResponseEntity.ok().body(user);
    }







}
