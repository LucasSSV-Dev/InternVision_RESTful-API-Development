package com.internvision.RESTfulAPIDevelopment.user.application.repository;

import com.internvision.RESTfulAPIDevelopment.user.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByActiveTrue();

    User findByEmail(String email);
}
