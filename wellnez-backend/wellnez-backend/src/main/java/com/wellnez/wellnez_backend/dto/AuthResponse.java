package com.wellnez.wellnez_backend.dto;

public class AuthResponse {
    private String message;
    private String email;
    private String username;
    private String name;
    private String role;

    public AuthResponse(String message, String email, String username, String name, String role) {
        this.message = message;
        this.email = email;
        this.username = username;
        this.name = name;
        this.role = role;
    }

    public String getMessage() { return message; }
    public String getEmail() { return email; }
    public String getUsername() { return username; }
    public String getName() { return name; }
    public String getRole() { return role; }
}
