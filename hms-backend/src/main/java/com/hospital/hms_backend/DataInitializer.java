package com.hospital.hms_backend;

import com.hospital.hms_backend.model.User;
import com.hospital.hms_backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Check if the admin user already exists
            if (userRepository.findByUsername("admin").isEmpty()) {
                
                User admin = new User();
                admin.setUsername("admin");
                // The magic happens here: take "admin123" and turn it into "$2a$10$..."
                admin.setPassword(passwordEncoder.encode("admin123")); 
                admin.setRole("ADMIN");
                
                userRepository.save(admin);
                System.out.println("✅ Admin user created! Username: admin | Password: admin123");
            }
        };
    }
}