package ru.edu.games.onlinestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.edu.games.onlinestore.entity.UserEntity;
import ru.edu.games.onlinestore.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserEntity createUser(UserEntity user){

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

}
