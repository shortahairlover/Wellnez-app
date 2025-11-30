package com.wellnez.wellnez_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // untuk sekarang matikan CSRF biar gampang test dari Postman / frontend
            .csrf(csrf -> csrf.disable())

            // kita anggap API-nya stateless (gak pakai session login form)
            .sessionManagement(sess -> 
                sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            .authorizeHttpRequests(auth -> auth
                // daftar endpoint yang boleh diakses bebas tanpa login
                .requestMatchers(
                    "/api/auth/**",     // register & login
                    "/api/public/**",   // kalau nanti ada
                    "/api/schedule/**", // schedule CRUD
                    "/api/food/**",
                    "/api/content/**"       // food_consumption CRUD
                ).permitAll()

                // sisanya juga sementara kita bebaskan saja
                .anyRequest().permitAll()
            );

        // kita gak pakai formLogin / httpBasic di sini
        return http.build();
    }
}
