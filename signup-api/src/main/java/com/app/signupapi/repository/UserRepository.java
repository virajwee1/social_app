package com.app.signupapi.repository;

import com.app.signupapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    Boolean existsByEmail(String emailAddress);
}
