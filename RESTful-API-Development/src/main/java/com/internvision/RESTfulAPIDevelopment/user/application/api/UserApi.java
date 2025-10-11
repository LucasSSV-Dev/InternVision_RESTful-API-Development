package com.internvision.RESTfulAPIDevelopment.user.application.api;

import com.internvision.RESTfulAPIDevelopment.user.application.api.dto.CreateUserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/users")
public interface UserApi {

    @PostMapping
    ResponseEntity<Object> postCreateUser(@RequestBody @Valid CreateUserDTO body);

    @GetMapping
    ResponseEntity<Object> getAllUsers();

    @GetMapping("/{id}")
    ResponseEntity<Object> getUserById(@PathVariable @Valid String id);
}
