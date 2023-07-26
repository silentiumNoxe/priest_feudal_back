package com.priestfeudal.auth.config;

import com.priestfeudal.auth.config.security.JwtAuthenticationEntryPoint;
import com.priestfeudal.auth.config.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationEntryPoint authenticationEntryPoint;
    private final JwtAuthenticationFilter authenticationJwtTokenFilter;
    private final List<AuthenticationProvider> providers;

    private static final String[] WHITELIST = {
            "/api/v1/auth/**",
    };

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        for (AuthenticationProvider provider : providers) {
            authenticationManagerBuilder.authenticationProvider(provider);
        }
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        for (AuthenticationProvider provider : providers) {
            http.authenticationProvider(provider);
        }
        http
                .csrf(conf -> conf.disable())
                .httpBasic(conf -> conf.disable())
                .formLogin(conf -> conf.disable())
                .authorizeHttpRequests(req ->
                        req.requestMatchers(WHITELIST)
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(e ->
                        e.authenticationEntryPoint(authenticationEntryPoint))
                .authenticationManager(authenticationManager)
                .addFilterBefore(authenticationJwtTokenFilter,
                        UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}

