package com.wellnez.wellnez_backend.service;

import com.wellnez.wellnez_backend.dto.AuthResponse;
import com.wellnez.wellnez_backend.dto.LoginRequest;
import com.wellnez.wellnez_backend.dto.RegisterRequest;
import com.wellnez.wellnez_backend.model.User;
import com.wellnez.wellnez_backend.respository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // REGISTER
    public AuthResponse register(RegisterRequest req) {

        if (!req.getPassword().equals(req.getConfirmPassword())) {
            throw new IllegalArgumentException("Password dan Confirm Password tidak sama");
        }

        if (userRepository.findByEmail(req.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email sudah terdaftar");
        }

        if (userRepository.findByUsername(req.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username sudah dipakai");
        }

        User user = new User();
        user.setEmail(req.getEmail());
        user.setUsername(req.getUsername());
        user.setName(req.getName());
        user.setPassword(req.getPassword()); // nanti bisa hash
        user.setRole("USER");

        userRepository.save(user);

        return new AuthResponse("Register berhasil", user.getEmail(), user.getUsername(), user.getName(), user.getRole());
    }

    // LOGIN
    public AuthResponse login(LoginRequest req) {

        User user = userRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Email tidak ditemukan"));

        if (!user.getPassword().equals(req.getPassword())) {
            throw new IllegalArgumentException("Password salah");
        }

        return new AuthResponse("Login berhasil", user.getEmail(), user.getUsername(), user.getName(), user.getRole());
    }
}
