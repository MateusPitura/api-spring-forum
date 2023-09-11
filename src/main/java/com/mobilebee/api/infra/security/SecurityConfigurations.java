package com.mobilebee.api.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
    
    @Autowired
    private SecurityFilter f;

    @Bean
    public SecurityFilterChain s(HttpSecurity h) throws Exception{
        h.csrf(c -> c.disable());
        h.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        h.authorizeHttpRequests(a -> a.requestMatchers(HttpMethod.POST, "/login").permitAll().anyRequest().authenticated());
        h.addFilterBefore(f, UsernamePasswordAuthenticationFilter.class);

        return h.build();
    }

    @Bean
    public AuthenticationManager a(AuthenticationConfiguration c) throws Exception{
        return c.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder m(){
        return new BCryptPasswordEncoder();
    }
    
}
