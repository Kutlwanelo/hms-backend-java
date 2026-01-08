package com.hospital.hms_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 1. Password Encoder (BCrypt)
    // This ensures to never store plain text passwords (e.g., "1234") in the database.
    // It converts "1234" into "$2a$10$wI..." so hackers can't read it.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 2. The Security Filter Chain (The Rules)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for simple APIs (standard for beginners)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/patients/**").authenticated() // Lock everything under /api/patients
                .anyRequest().permitAll() // Allow everything else (like error pages)
            )
            .httpBasic(Customizer.withDefaults()); // Use Basic Auth (Pop-up login)

        return http.build();
    }
}