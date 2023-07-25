package com.priestfeudal.auth.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final JwtUtils jwtUtils;
    private final UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String jwt = (String) authentication.getPrincipal();
        UsernamePasswordAuthenticationToken auth = null;

        if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
            final String username = jwtUtils.getEmailFromToken(jwt);

            final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            auth = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            authentication,
                            userDetails.getAuthorities());
            auth.setDetails(authentication.getDetails());

            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return DaoAuthenticationProvider.class.isAssignableFrom(authentication);
    }

}
