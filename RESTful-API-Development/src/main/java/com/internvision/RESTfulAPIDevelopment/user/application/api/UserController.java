package com.internvision.RESTfulAPIDevelopment.user.application.api;

import com.internvision.RESTfulAPIDevelopment.user.application.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class UserController implements UserApi {

    private UserService userService;




}
