package com.app.signupapi.configuration;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class CustomAuditAware implements AuditorAware<String> {

    //Returns string until the user module is implemented
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("user-name");
    }
}
