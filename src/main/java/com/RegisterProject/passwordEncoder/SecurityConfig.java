package com.RegisterProject.passwordEncoder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http
            .csrf(csrf -> csrf.disable()) // ✅ Updated: disable CSRF using lambda
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // ✅ Allow all endpoints
                );

        return http.build();
    }
}

