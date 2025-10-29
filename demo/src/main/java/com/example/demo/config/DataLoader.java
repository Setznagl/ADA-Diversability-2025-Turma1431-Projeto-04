package com.example.demo.config;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner seedUsers(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (usuarioRepository.findByUsername("ash").isEmpty()) {
                Usuario user = new Usuario();
                user.setUsername("ash");
                user.setPassword(passwordEncoder.encode("pikachu123"));
                user.setRole("ADMIN");
                usuarioRepository.save(user);

                System.out.println("👤 Usuário inicial criado: ash / pikachu123");
            }

            if (usuarioRepository.findByUsername("brock").isEmpty()) {
                Usuario user = new Usuario();
                user.setUsername("brock");
                user.setPassword(passwordEncoder.encode("onyx123"));
                user.setRole("USER");
                usuarioRepository.save(user);

                System.out.println("👤 Usuário inicial criado: brock / onyx123");
            }
        };
    }
}

