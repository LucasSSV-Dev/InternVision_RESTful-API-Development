package com.internvision.RESTfulAPIDevelopment.user.application.api;

import com.internvision.RESTfulAPIDevelopment.user.application.api.dto.CreateUserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/users")
public interface UserApi {

    @PostMapping
    ResponseEntity<Object> createUser(@RequestBody @Valid CreateUserDTO body);



}
