package com.priestfeudal.auth.config.security;

import com.priestfeudal.libcommons.utils.RequestIdGenerator;
import com.priestfeudal.libcommons.utils.RequestIdHolder;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtAuthenticationProvider authenticationProvider;
    private final RequestIdGenerator requestIdGenerator;
    private final RequestIdHolder requestIdHolder;
    private final JwtAuthenticationEntryPoint authenticationEntryPoint;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String id = request.getHeader("X-REQUEST-ID");
        if (id == null || id.isEmpty()) {
            UUID requestId = requestIdGenerator.generate();
            log.info("Request id = {} was generated", requestId);
            requestIdHolder.save(requestId);
        } else {
            log.info("Request id = {} was generated", id);
            requestIdHolder.save(UUID.fromString(id));
        }

        String jwt = extractJwt(request);
        if (jwt == null || jwt.equals(""))  {
            filterChain.doFilter(request, response);
        }
        JwtAuthenticationToken token = new JwtAuthenticationToken(jwt);
        Authentication authentication = null;
        try {
            authentication = authenticationProvider.authenticate(token);
        } catch (AuthenticationException e) {
            log.info(e.getMessage());
            authenticationEntryPoint.commence(request, response, e);
            SecurityContextHolder.clearContext();
        }
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);
        filterChain.doFilter(request, response);
    }

    private String extractJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring("Bearer ".length());
        }
        return null;
    }
}
