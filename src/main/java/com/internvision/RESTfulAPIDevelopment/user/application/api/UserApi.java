package com.internvision.RESTfulAPIDevelopment.user.application.api;

import com.internvision.RESTfulAPIDevelopment.user.application.api.dto.ChangePasswordRequestDTO;
import com.internvision.RESTfulAPIDevelopment.user.application.api.dto.CreateOrUpdateUserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/users")
public interface UserApi {

    @PostMapping
    ResponseEntity<Object> postCreateUser(@RequestBody @Valid CreateOrUpdateUserDTO body);

    @GetMapping
    ResponseEntity<Object> getAllUsers();

    @GetMapping("/{id}")
    ResponseEntity<Object> getUserById(@PathVariable @Valid String id);

    @PutMapping("/{id}")
    ResponseEntity<Object> putUpdateUser(@PathVariable String id, @RequestBody @Valid CreateOrUpdateUserDTO body);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable @Valid String id);

    @PatchMapping("/{id}")
    ResponseEntity<Object> patchUpdateUser(@PathVariable @Valid String id, @RequestBody @Valid ChangePasswordRequestDTO body);

}
