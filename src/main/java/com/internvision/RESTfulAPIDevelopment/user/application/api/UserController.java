package com.internvision.RESTfulAPIDevelopment.user.application.api;

import com.internvision.RESTfulAPIDevelopment.user.application.api.dto.ChangePasswordRequestDTO;
import com.internvision.RESTfulAPIDevelopment.user.application.api.dto.CreateOrUpdateUserDTO;
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
    public ResponseEntity<Object> postCreateUser(CreateOrUpdateUserDTO dto) {
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


    @Override
    public ResponseEntity<Object> putUpdateUser(String id, CreateOrUpdateUserDTO userUpdateRequest) {
        log.info("[starts] UserController -> putUpdateUser()");
        userService.updateUser(id, userUpdateRequest);
        log.info("[ends] UserController -> putUpdateUser()");
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteUser(String id) {
        log.info("[starts] UserController -> deleteUser()");
        userService.deleteUser(id);
        log.info("[ends] UserController -> deleteUser()");
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Object> patchUpdateUser(String id, ChangePasswordRequestDTO passwordRequestDTO) {
        log.info("[starts] UserController -> patchUpdateUser()");
        userService.changePassword(id, passwordRequestDTO);
        log.info("[ends] UserController -> patchUpdateUser()");
        return ResponseEntity.accepted().body("Password changed!");
    }



}
