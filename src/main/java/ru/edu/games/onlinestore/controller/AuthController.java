package ru.edu.games.onlinestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.edu.games.onlinestore.dto.AuthResponse;
import ru.edu.games.onlinestore.dto.LoginDto;
import ru.edu.games.onlinestore.dto.RegisterDto;
import ru.edu.games.onlinestore.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginDto loginDto) {
        return authService.login(loginDto);
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterDto registerDto) {
        return authService.register(registerDto);
    }

}
