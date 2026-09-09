package ru.edu.games.onlinestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.edu.games.onlinestore.dto.LoginDto;
import ru.edu.games.onlinestore.entity.UserEntity;
import ru.edu.games.onlinestore.repository.UserRepository;
import ru.edu.games.onlinestore.security.JwtService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String login (LoginDto loginDto){

        UserEntity user = userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) throw new RuntimeException("Incorrect password!");

        return jwtService.generateToken(user.getEmail());


    }


}
