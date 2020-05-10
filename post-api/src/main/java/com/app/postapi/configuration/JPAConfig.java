package com.app.postapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JPAConfig {

    @Bean
    public CustomAuditAware auditorProvidor() {
        return new CustomAuditAware();
    }
}