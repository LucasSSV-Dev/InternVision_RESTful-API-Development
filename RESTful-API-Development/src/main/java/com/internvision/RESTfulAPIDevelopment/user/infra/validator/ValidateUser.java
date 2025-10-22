package com.internvision.RESTfulAPIDevelopment.user.infra.validator;

import com.internvision.RESTfulAPIDevelopment.globalhandler.exception.EmailAlreadyUsedException;
import com.internvision.RESTfulAPIDevelopment.user.application.repository.UserRepository;
import com.internvision.RESTfulAPIDevelopment.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateUser {
    private final UserRepository userRepository;

    public void VerifyEmail(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new EmailAlreadyUsedException("Email already used!");
        }
    }

}
