package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UsuarioController {

    @GetMapping("/user")
    public Map<String, Object> obterUsuario() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return Map.of(
                "username", auth.getName(),
                "authorities", auth.getAuthorities()
        );
    }
}