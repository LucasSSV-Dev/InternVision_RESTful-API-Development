package com.internvision.RESTfulAPIDevelopment.user.infra;

import com.internvision.RESTfulAPIDevelopment.user.application.repository.UserRepository;
import com.internvision.RESTfulAPIDevelopment.user.application.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
public class UserApplicationService implements UserService {

    private UserRepository userRepository;

}
