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

@RestController
@Log4j2
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<Object> createUser(CreateUserDTO dto) {
        User user = userService.createUser(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }









}
