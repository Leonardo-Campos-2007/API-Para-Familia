package com.br.leoo;

// ✅ Crie esse arquivo em: com.br.leoo


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())        // ✅ Desativa CSRF para testes
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()         // ✅ Libera todas as rotas
            );
        return http.build();
    }
}
